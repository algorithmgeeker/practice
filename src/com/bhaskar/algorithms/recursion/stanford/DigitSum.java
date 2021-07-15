package com.bhaskar.algorithms.recursion.stanford;

import java.util.Scanner;

public class DigitSum {

    public static void main(String[] args) {
        System.out.print("Enter Number : ");
        Scanner in = new Scanner(System.in);
        //iterativeFeb(in.nextInt());
        int n = in.nextInt();
        System.out.print("Sum of " + n + " : " + calculateSum(n));
    }

    private static int calculateSum(int number) {
        if(number == 0)
            return 0;

        return (number % 10) + calculateSum(number / 10);
    }
}
