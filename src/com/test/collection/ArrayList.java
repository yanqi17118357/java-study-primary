package com.test.collection;

public class ArrayList<E> {
    int capacity = 10;
    int size = 0;
    private Object[] array =new Object[capacity];

    public void add(E element, int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("插入的位置非法，插入合法的位置：0~" + size);
        if (capacity == size) {
            int newCapacity = capacity + (capacity >> 1);
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
            capacity = newCapacity;
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }

    // 屏蔽未经检查警告
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("删除的位置非法，插入合法的位置：0~" + size);
        E e = (E) array[index];
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return e;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            builder.append(array[i]).append(" ");
        }
        return builder.toString();
    }
}
