package com.test.entity;

import com.test.entity.Person;

public class Student extends Person {

    public Student(String name, int age, String gender) {
        super(name, age, gender);
    }

    public void bye() {
        System.out.println("bye bye");
    }
}
