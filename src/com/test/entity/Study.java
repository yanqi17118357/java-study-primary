package com.test.entity;

public interface Study extends C{

    void study();
    default void test() {
        System.out.println("test");
    }
}
