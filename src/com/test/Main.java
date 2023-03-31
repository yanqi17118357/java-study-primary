package com.test;

public class Main {
    private static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        Main main2 = new Main();
        new Thread(() -> {
            for (int j = 0; j < 100000; j++) {
                synchronized (main) {
                    System.out.println("这里是线程1");
                    try {
                        Thread.sleep(1000);
                        synchronized (main2) {
                            System.out.println("调用main锁");
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        }).start();

        new Thread(() -> {
            for (int j = 0; j < 100000; j++) {
                synchronized (main2) {
                    System.out.println("这里是线程2");
                    try {
                        Thread.sleep(1000);
                        synchronized (main) {
                            System.out.println("这里是main锁");
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();

        System.out.println("这里是主线程");

    }
}
