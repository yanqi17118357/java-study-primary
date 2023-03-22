package com.test.collection;

public class LinkedList<E> {
    // 链表的头结点，连接之后的所有结点
    private final Node<E> head = new Node<>(null);
    private int size = 0;

    public void add(E element, int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("插入的位置非法，插入合法的位置：0~" + size);
        // 找前驱结点
        Node<E> prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        // 插入新结点
        Node<E> node = new Node<>(element);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("删除的位置非法，插入合法的位置：0~" + size);
        Node<E> prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        E e = prev.next.element;
        prev.next = prev.next.next;
        return e;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<E> node = head.next;
        while (node != null) {
            builder.append(node.element).append(" ");
            node = node.next;
        }
        return builder.toString();
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }
}
