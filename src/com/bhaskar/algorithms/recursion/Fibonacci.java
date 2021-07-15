package com.bhaskar.algorithms.recursion;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.print("Enter Number : ");
        Scanner in = new Scanner(System.in);
        //iterativeFeb(in.nextInt());
        int n = in.nextInt();
        System.out.print("Fibonacci series : ");
        for (int i = 0; i < n; i++) {
            System.out.print(recursiveFeb(i) + " ");
        }
    }

    private static void iterativeFeb(int limit) {
        int firstElement = 0;
        int secondElement = 1;
        int tmp;

        for (int i = 0; i < limit; i++) {

            if (i == 0)
                System.out.println(0);
            else if (i == 1)
                System.out.println(1);
            else {
                tmp = firstElement;
                firstElement = secondElement;
                secondElement = tmp + secondElement;
                System.out.println(secondElement + "  Ratio : " + ((double) secondElement / (double) firstElement));
            }
        }
    }

    // Use Recursion Tree to understand
    private static int recursiveFeb(int limit) {
        if (limit <= 1)
            return limit;

        return recursiveFeb(limit - 1) + recursiveFeb(limit - 2);
    }
}
