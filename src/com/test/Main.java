package com.test;

import com.test.entity.*;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        Object w1 = new Student("小刚",18,"男");
        Object w2 = new Student("小刚",18,"男");
        System.out.println(w1.equals(w2));


    }
}
