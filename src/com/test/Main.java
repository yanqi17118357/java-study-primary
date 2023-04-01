package com.test;


import java.lang.annotation.Annotation;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException {
        Class<Student> clazz = Student.class;
        for (Annotation annotation : clazz.getMethod("test").getAnnotations()) {
            System.out.println(annotation.annotationType());   //获取类型
            System.out.println(annotation instanceof Test);   //直接判断是否为Test
            Test test = (Test) annotation;
            System.out.println(Arrays.toString(test.value()));   //获取我们在注解中写入的内容
        }
    }

}
