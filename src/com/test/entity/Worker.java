package com.test.entity;

public class Worker extends Person{
    String name;
    public Worker(String name, int age, String gender) {
        super(name, age, gender);
    }

    public void work() {
        System.out.println("我是"+name+"我在工作！");
    }
}
