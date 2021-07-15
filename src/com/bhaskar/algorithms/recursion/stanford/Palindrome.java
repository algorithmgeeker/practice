package com.bhaskar.algorithms.recursion.stanford;

import java.util.Scanner;

// abccba
public class Palindrome {
    public static void main(String[] args) {
        System.out.print("Enter String : ");
        Scanner in = new Scanner(System.in);
        //iterativeFeb(in.nextInt());
        String n = in.nextLine();
        System.out.print(n + " is Palindrome : " + iterativeIsPalindrome(n));
    }

    private static boolean iterativeIsPalindrome(String string) {
        for(int i=0; i<string.length(); i++) {
            if(string.charAt(i) != string.charAt(string.length() -1 -i))
                return false;
        }
        return true;
    }

    private static boolean recursiveIsPalindrome(String s, int index) {
        int startIndex = index;
        int endIndex = s.length() - 1 - index;
        boolean result = false;
        if(startIndex == endIndex)
            return true;
        recursiveIsPalindrome(s, index + 1);
        if(s.charAt(index) != s.charAt(s.length() -1 -index))
            return true;
        else
            return false;
    }
}
