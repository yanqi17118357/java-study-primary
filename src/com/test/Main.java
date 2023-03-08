package com.test;

import com.test.entity.Inner;
import com.test.entity.Student;
import com.test.entity.Study;

public class Main {

    public static void main(String[] args) {
        // Student student = new Student() {
        //     @Override
        //     public void test() {
        //         System.out.println("我是匿名内部类");
        //     }
        // };
        // student.test();
        // Study study = new Study(){
        //     @Override
        //     public void study() {
        //
        //     }
        // };
        Inner inner = new Inner();
        inner.makeStudent().test();


    }
}

