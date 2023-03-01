package com.test.entity;

public class Person {
    private String name;
    private int age;
    private String gender;

    // 可以使用protected, 只能子类和同包用
    protected Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void hello() {
        System.out.println("你好！");
    }
}
