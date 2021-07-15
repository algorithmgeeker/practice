package com.bhaskar.algorithms.practice;

import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        System.out.print("Enter Number : ");
        Scanner in = new Scanner(System.in);
        //iterativeFeb(in.nextInt());
        int n = in.nextInt();
        System.out.print("Factorial of " + n + " : " + fact(n));
    }


    private static int fact(int n) {
        if(n == 1 || n == 0)
            return 1;
        return fact(n-1) * n;
    }
}
