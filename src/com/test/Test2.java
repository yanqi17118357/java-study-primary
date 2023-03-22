package com.test;

import com.test.collection.HashTable;

public class Test2 {
    public static void main(String[] args) {
        HashTable<Integer> hashTable = new HashTable<>();
        for (int i = 0; i < 70; i++) {
            hashTable.insert(i);
        }
        System.out.println(hashTable);
    }
}
