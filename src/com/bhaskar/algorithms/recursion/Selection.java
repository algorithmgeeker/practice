package com.bhaskar.algorithms.recursion;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Selection {
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
        int res = select(uSort, 0, uSort.length - 1,2);
        System.out.print("Element :  " + res);

    }

    public static int select(int[] arr, int start, int end, int order) {
        //Base Case
        if(start > end)
            return -1;

            int pIndex = getPivotIndex(start, end);
            int tmp = arr[start];
            System.out.println(tmp);
            System.out.println(arr[start]);
            arr[start] = arr[pIndex];
        System.out.println(arr[pIndex]);
            arr[pIndex] = tmp;
        System.out.println(tmp);
        System.out.println(Arrays.toString(arr) + " , Index " + pIndex + "  Start : " + start + " end : " + end);

        int tracker = start + 1;
            for (int i = start + 1; i <= end; i++) {
                if (arr[start] >= arr[i]) {
                    tmp = arr[i];
                    arr[i] = arr[tracker];
                    arr[tracker] = tmp;
                    tracker++;
                }
            }
        System.out.println(Arrays.toString(arr));
            if ((order - 1) == tracker - 1)
                return arr[start];
            tmp = arr[tracker - 1];
            arr[tracker - 1] = arr[start];
            arr[start] = tmp;
            if ((order -1) < tracker - 1)
               return select(arr, start, tracker - 2, order);
            else
               return select(arr, tracker, end, order - tracker);
    }

    private static int getPivotIndex(int start, int end) {
        Random rand = new Random();
        int r =  start + rand.nextInt((end-start));
        System.out.println(r);
        return r;
    }
}
