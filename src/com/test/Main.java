package com.test;

import com.test.entity.Study;

public class Main {

    public static void main(String[] args) {
        test(a -> "今天学会了"+a);   //参数直接写成lambda表达式
    }

    private static void test(Study study){
        System.out.println(study.study(10));
    }
}

