package com.bhaskar.algorithms.practice;

public class FindSortestArray {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {};
        System.out.println(searchMatrix(matrix, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        final int rowLength = matrix.length;
        if(rowLength == 0)
            return false;


        final int colLength = matrix[0].length;
        final int totalElement = rowLength * colLength;
        int flag = 0;
        int start = 0;
        int end = totalElement -1;
        int mid = end/2;

        while(true) {
            int rowPos = mid/colLength;
            int colPos = mid % colLength;

            if(matrix[rowPos][colPos] == target) {
                flag = 1;
                break;
            }

            if(start >= end)
                break;

            if(target < matrix[rowPos][colPos]) {
                end = mid - 1;
                mid = start + ((end - start) /2);
            } else {
                start = mid + 1;
                mid = start + ((end - start) /2);
            }
        }

        return flag == 1;
    }
}
