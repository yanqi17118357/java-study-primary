package com.test.collection;

import java.util.Arrays;

public class HashTable<E> {
    private final int TABLE_SIZE = 10;
    private final Node<E>[] TABLE = new Node[TABLE_SIZE];

    public HashTable() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            TABLE[i] = new Node<>(null);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < TABLE_SIZE; i++) {
            Node<E> head = TABLE[i].next;
            while (head != null) {
                builder.append(head.element).append("->");
                head = head.next;
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public void insert(E obj) {
        int index = hash(obj);
        Node<E> head = TABLE[index];
        Node<E> node = new Node<>(obj);
        node.next = head.next;
        head.next = node;
    }

    public boolean contains(E element) {
        int index = hash(element);
        Node<E> node = TABLE[index].next;
        while(node != null) {
            if (node.element == element)
                return true;
            node = node.next;
        }
        return false;
    }

    private int hash(E obj) {
        int hashCode = obj.hashCode();
        return  hashCode % TABLE_SIZE;
    }

    private static class Node<E> {
        private final E element;
        private Node<E> next;

        private Node(E element) {
            this.element = element;
        }
    }
}
