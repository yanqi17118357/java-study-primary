package com.test.entity;

import com.test.entity.Person;

public class Student extends Person implements Study, Cloneable{

    public Student(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public void study() {

    }

    @Override
    public void test() {
        Study.super.test();
    }
}
