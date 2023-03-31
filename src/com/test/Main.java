package com.test;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread main = Thread.currentThread();
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println("我是守护线程");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t.setDaemon(true);
        t.start();

        Thread.sleep(3000);
    }
}
