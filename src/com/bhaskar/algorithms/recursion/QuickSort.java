package com.bhaskar.algorithms.recursion;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class QuickSort {
    public static void main(String[] args) {
        System.out.print("Enter String : ");
        Scanner in = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(in.nextLine(), " ");
        int[] uSort = new int[st.countTokens()];
        int index = 0;
        while (st.hasMoreTokens()) {
            uSort[index] = Integer.parseInt(st.nextToken());
            index++;
        }
        partition(uSort, 0, uSort.length - 1);
        System.out.print("Sorted Array  :  " + Arrays.toString(uSort));
    }

    private static int choosePivot(int[] arr, int end, int start){
        Random rand = new Random();
        return start + rand.nextInt((end-start));
    }

    private static void partition(int[] inpArr, int start, int end) {
        if(start < end) {
            int pivotIndex = choosePivot(inpArr, end, start);
            int pivot = inpArr[pivotIndex];
            int tmp = 0;
            tmp = inpArr[start];
            inpArr[start] = pivot;
            inpArr[pivotIndex] = tmp;

            int mid = start + 1;

            for(int i=start + 1; i<=end; i++) {
                if(inpArr[i] <= pivot) {
                    tmp = inpArr[mid];
                    inpArr[mid] = inpArr[i];
                    mid = mid + 1;
                    inpArr[i] = tmp;
                }
            }
            tmp = inpArr[mid -1];
            inpArr[mid -1] = pivot;
            inpArr[start] = tmp;
            partition(inpArr, start, mid -2);
            partition(inpArr, mid, end);
        }
        //return inpArr;
    }
}
