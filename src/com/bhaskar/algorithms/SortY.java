package com.bhaskar.algorithms;

import java.util.Comparator;

public class SortY {



    public static class Pair implements Comparator<Integer> {
        final public int x;
        final public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;

        }

        @Override
        public int compare(Integer integer, Integer t1) {
            return 0;
        }
    }
}
