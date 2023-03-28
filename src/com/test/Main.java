package com.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Main {

    private static final List<Book> LIST = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=====================图书管理系统=====================");
            System.out.println("1.录入书籍信息");
            System.out.println("2.查阅书籍信息");
            System.out.println("3.删除书籍信息");
            System.out.println("4.修改书籍信息");
            System.out.println("5.退出系统");
            System.out.println("====================================================");

            switch (scanner.nextInt()) {
                case 1:
                    insert(scanner);
                    break;
                case 5:
                    System.out.println("拜拜");
                    return;
            }
        }
    }

    private static void insert(Scanner scanner) {
        scanner.nextLine();
        Book book = Book.builder()
                .title(scanner.nextLine())
                .author(scanner.nextLine())
                .price(scanner.nextInt())
                .build();
        scanner.nextLine();

        LIST.add(book);
        System.out.println(LIST);

    }
}







