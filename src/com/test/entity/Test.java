package com.test.entity;

public class Test {
    public void hello() {
        class Inn{
            public void hello() {
                System.out.println("hello");
            }
        }
        Inn inn = new Inn();
        inn.hello();
    }
    public static class Inner {
        public void test() {
            System.out.println("test");
        }


    }
}
