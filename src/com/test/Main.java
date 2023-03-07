package com.test;


import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        int[] arr = new int[10];
        int[] arr2 = new int[10];
        System.out.println(equals(arr2,arr));

    }

    private static boolean equals(int[] a, int[] b) {
        int length = a.length;
        if (b.length != length) return false;
        for (int i = 0; i < length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
