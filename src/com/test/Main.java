package com.test;

import com.test.entity.Test;

public class Main {

    public static void main(String[] args) {
        Test.Inner inner = new Test.Inner();
        inner.test();
        Test test = new Test();
        test.hello();
    }
}

