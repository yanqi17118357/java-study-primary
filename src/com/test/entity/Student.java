package com.test.entity;

public abstract class Student {
    static {
        System.out.println("这里是静态代码块");
    }
    public abstract void test();
}
