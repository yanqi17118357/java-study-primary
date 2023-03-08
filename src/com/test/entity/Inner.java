package com.test.entity;

public class Inner extends Test{
    Student makeStudent() {
        return new Student() {
            @Override
            public void test() {
                System.out.println("这里是匿名内部类");
            }
        };
    }
}
