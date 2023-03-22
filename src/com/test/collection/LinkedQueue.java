package com.test.collection;

import java.util.NoSuchElementException;

public class LinkedQueue<E> {

    private final Node<E> head = new Node<>(null);

    public void offer(E element){
        Node<E> last = head;
        while (last.next != null)
            last = last.next;
        last.next = new Node<>(element);
    }

    public E poll(){
        if(head.next == null)
            throw new NoSuchElementException("队列为空");
        E e = head.next.element;
        head.next = head.next.next;
        return e;
    }

    public boolean isEmpty(){   //这里多写了一个判断队列为空的操作，方便之后使用
        return head.next == null;   //直接看头结点后面还有没有东西就行了
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }
}
