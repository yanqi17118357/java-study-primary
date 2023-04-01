package com.test;


public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        //通过包名
        Class<?> clazz = Class.forName("com.test.Student");
        //通过new一个对象
        Class<?> clazz2 = new Student().getClass();
        //直接类.class
        Class<?> clazz3 = Student.class;

        Class<?> c = int.class;

    }
}
