package com.bhaskar.algorithms;

public class BinarySearch {

    public static boolean search(int key, int[] arr) {
        boolean hasKey = false;
        int start = 0;
        int end = arr.length - 1;
        int mid = start + ((end - start) /2);
        while(true) {
            if(arr[mid] == key) {
                hasKey = true;
                break;
            }

            if(start >= end)
                break;

            if(key < arr[mid]) {
                end = mid - 1;
                mid = start + ((end - start) /2);
            } else {
                start = mid + 1;
                mid = start + ((end - start) /2);
            }
        }
        return hasKey;
    }
}
