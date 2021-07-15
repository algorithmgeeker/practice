package com.bhaskar.algorithms.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MergeSort {
    private int numberOfInversions;

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
        System.out.print("Sorted Array  :  " + Arrays.toString(countInversion(uSort, 0, uSort.length - 1).sortedArray));
        System.out.print("Number of Inversion :  " + countInversion(uSort, 0, uSort.length - 1).numberOfInversion);
    }

    private static int[] sort(int[] array, int start, int end) {
        if (start == end)
            return new int[]{array[start]};

        int middle = (start + end) / 2;
        int[] lSort = sort(array, start, middle);
        int[] rSort = sort(array, middle + 1, end);
        return merge(lSort, rSort);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] array = new int[first.length + second.length];
        int count = 0;
        int i = 0;
        int j = 0;
        while (true) {

            // first array end
            if (i == first.length && j < second.length) {
                while (j < second.length) {
                    array[count] = second[j];
                    j++;
                    count++;
                }
                break;
            }
            // second array end
            if (j == second.length && i < first.length) {
                while (i < first.length) {
                    array[count] = first[i];
                    i++;
                    count++;
                }
                break;
            }

            if (first[i] < second[j]) {
                array[count] = first[i];
                i++;
            } else {
                array[count] = second[j];
                j++;
            }
            count++;
        }
        return array;
    }

    private static Pair countInversion(int[] array, int start, int end) {
        if (start == end)
            return new Pair(new int[]{array[start]}, 0);

        int middle = (start + end) / 2;
        Pair lInversion = countInversion(array, start, middle);
        Pair rInversion = countInversion(array, middle + 1, end);
        return countSplitInversion(lInversion.sortedArray, rInversion.sortedArray);
    }


    //TODO: This can be make efficient
    private static Pair countSplitInversion(int[] lArray, int[] rArray) {
        int[] sortedLArray = sort(lArray, 0, lArray.length - 1);
        int[] sortedRArray = sort(rArray, 0, rArray.length - 1);

        int rightIndex = 0;
        int numberOfInversion = 0;
        for (int i = 0; i < sortedRArray.length; i++) {
            if (sortedLArray[i] > sortedRArray[rightIndex]) {
                numberOfInversion = numberOfInversion + (sortedLArray.length - i);
                System.out.println(i);
                // Dirty trick for staying in same element
                i--;
                rightIndex++;
                System.out.println(i);
            }
        }
        return new Pair(merge(sortedLArray, sortedRArray), numberOfInversion);
    }

    static class Pair {
        private final int[] sortedArray;
        private final int numberOfInversion;

        Pair(int[] sortedArray, int numberOfInversion) {
            this.sortedArray = sortedArray;
            this.numberOfInversion = numberOfInversion;
        }

        public int[] getSortedArray() {
            return sortedArray;
        }

        public int getNumberOfInversion() {
            return numberOfInversion;
        }
    }
}