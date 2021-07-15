package com.bhaskar.algorithms.recursion;

import com.bhaskar.algorithms.BinarySearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MergeSort {

    public static void main(String[] args) {
        System.out.print("Enter Array : ");
        Scanner in = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(in.nextLine(), " ");
        int[] uSort = new int[st.countTokens()];
        int index = 0;
        while (st.hasMoreTokens()) {
            uSort[index] = Integer.parseInt(st.nextToken());
            index++;
        }
        Arrays.sort(uSort);
        System.out.print("Enter Key : ");
        int key = in.nextInt();
        System.out.print("HasKey: " + BinarySearch.search(key, uSort));
        //System.out.print("Sorted Array  :  " + Arrays.toString(split(uSort, 0, uSort.length -1)));
    }

    private static int[] split(int[] list, int startIndex, int endIndex) {
        if(startIndex == endIndex)
            return new int[]{list[startIndex]};
        else {
            int middle = (startIndex + endIndex) / 2;
            int[] lSort = split(list, startIndex, middle);
            int[] rSort =  split(list, middle+1, endIndex);
            return merge(lSort, rSort);
        }
    }

    private static int[] merge(int[] lSort, int[] rSort) {
        int i =0;
        int j=0;
        int index = 0;
        int[] tmpSort = new int[lSort.length + rSort.length];
        while (true) {
            if(i == lSort.length) {
                if(rSort.length != j) {
                    while (j < rSort.length) {
                        tmpSort[index] = rSort[j];
                        index++;
                        j++;
                    }
                }
                break;
            } else if(j == rSort.length) {
                    while (i < lSort.length) {
                        tmpSort[index] = lSort[i];
                        index++;
                        i++;
                    }
                    break;
            }
            if(lSort[i] <= rSort[j]) {
                tmpSort[index] = lSort[i];
                index++;
                i++;
            } else {
                tmpSort[index] = rSort[j];
                index++;
                j++;
            }
        }
        return tmpSort;
    }
}
