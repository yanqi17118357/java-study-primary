package com.test;

import com.test.collection.LinkedStack;

import java.util.Optional;

public class Test {
    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
}
