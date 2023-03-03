package com.test;


import com.test.entity.Person;
import com.test.entity.Student;
import com.test.entity.Worker;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        Person student = new Student("",12,"");
        if (student instanceof Student){
            System.out.println("是Student类型的");
        }
    }
}
