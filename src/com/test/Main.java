package com.test;


import java.lang.reflect.Field;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws ReflectiveOperationException {
        Integer i = new Integer(10);

        Field value = Integer.class.getDeclaredField("value");
        value.setAccessible(true);

        value.set(i, 19);
        value.set(i, 20);
        System.out.println(value.get(i));


    }
}
