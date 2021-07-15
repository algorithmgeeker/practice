package com.bhaskar.algorithms.practice;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HeapSort {
    private static PriorityQueue<Integer> heap;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        StringTokenizer st = new StringTokenizer(input, " ");
        int len = st.countTokens();
        heap = new PriorityQueue<>(len);
        arr = new int[len];
        while (st.hasMoreTokens())
            heap.add(Integer.parseInt(st.nextToken()));
        for (int i=0; i<len; i++)
            arr[i] = heap.remove();
        System.out.print(Arrays.toString(arr));
    }
}
