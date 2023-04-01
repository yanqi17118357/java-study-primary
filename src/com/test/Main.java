package com.test;


import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Main {


    //定义一个自己的ClassLoader
    static class MyClassLoader extends ClassLoader{
        public Class<?> defineClass(String name, byte[] b){
            return defineClass(name, b, 0, b.length);   //调用protected方法，支持载入外部class文件
        }
    }

    public static void main(String[] args) throws IOException, ReflectiveOperationException{
        MyClassLoader classLoader = new MyClassLoader();
        FileInputStream stream = new FileInputStream("Test.class");
        byte[] bytes = new byte[stream.available()];
        stream.read(bytes);
        Class<?> clazz = classLoader.defineClass("com.test.Test", bytes);   //类名必须和我们定义的保持一致
        Object o = clazz.newInstance();

        Method method = clazz.getDeclaredMethod("test");
        method.setAccessible(true);

        method.invoke(o);

    }
}
