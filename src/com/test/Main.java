package com.test;


import com.test.entity.Status;
import com.test.entity.Student;

public class Main {

    public static void main(String[] args) {
        Student student = new Student();
        student.setStatus(Status.RUNNING);
        System.out.println(student.getStatus().getName());
    }
}
