package com.test;


import com.test.entity.Person;
import com.test.entity.Student;
import com.test.entity.Study;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student("小明", 18, "男");
        Student clone = (Student) student.clone();
        System.out.println(student == clone);
    }
}
