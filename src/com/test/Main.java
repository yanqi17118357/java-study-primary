package com.test;


import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            System.out.println("there is try");
            int a = 1;
            a /= 0;
        } catch (RuntimeException e){  //使用运行时异常同样可以捕获到
            System.out.println("捕获到异常");
        } finally {
            System.out.println("there is finally");
        }
    }
}

