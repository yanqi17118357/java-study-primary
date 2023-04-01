package com.test;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        }).start();

        Thread.sleep(1000);
        System.out.println(list.size());
    }
}
