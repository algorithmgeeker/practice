package com.bhaskar.algorithms.recursion.stanford;

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
        if(n == 1)
            return 1;
        return n * fact(n -1);
    }
}
