package com.bhaskar.algorithms.recursion.stanford;

import java.util.Scanner;

public class ReverseString {

    public static void main(String[] args) {
        System.out.print("Enter String : ");
        Scanner in = new Scanner(System.in);
        //iterativeFeb(in.nextInt());
        String n = in.nextLine();
        System.out.print("Reverse of " + n + " : " + reverse(n, 0));
    }

    private static String reverse(String string, int start) {
        if(string.length() == start)
            return "";
        return reverse(string, start +1) + string.charAt(start);
    }
}
