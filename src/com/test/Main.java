package com.test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Main {

    private static List<Book> LIST;

    public static void main(String[] args) {
        System.out.println("正在初始化图书管理系统...");
        load();
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
                case 2:
                    query();
                    break;
                case 3:
                    delete(scanner);
                    break;
                case 4:
                    modify(scanner);
                    break;
                case 5:
                    System.out.println("正在保存图书数据...");
                    save();
                    System.out.println("感谢使用，拜拜！");
                    return;
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static void load() {
        File file = new File("data.txt");
        if (file.exists()) {
            try (ObjectInputStream stream = new ObjectInputStream(Files.newInputStream(Paths.get("data.txt")))) {
                LIST = (List<Book>) stream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            LIST = new LinkedList<>();
        }
    }

    private static void save() {
        try (ObjectOutputStream stream = new ObjectOutputStream(Files.newOutputStream(Paths.get("data.txt")))) {
            stream.writeObject(LIST);
            stream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static void insert(Scanner scanner) {
        // 由于nextInt()方法不会获取回车键，所以这里和下面都要消耗一下
        scanner.nextLine();
        System.out.println("请输入书籍名称");
        String name = scanner.nextLine();
        System.out.println("请输入作者名称");
        String author = scanner.nextLine();
        System.out.println("请输入书籍价格");
        int price = scanner.nextInt();
        Book book = new Book(name, author, price);
        // 同上
        scanner.nextLine();

        LIST.add(book);
        System.out.println("书籍添加成功：" + book);
    }

    private static void query() {
        for (int i = 0; i < LIST.size(); i++) {
            System.out.println(i + "." + LIST.get(i));
        }
    }

    private static void modify(Scanner scanner) {
        scanner.nextLine();
        System.out.println("请输入你要修改的书籍编号");
        int index = scanner.nextInt();
        scanner.nextLine();
        while (index > LIST.size() - 1 || index < 0) {
            System.out.println("书籍标号不合法，请重新输入");
            index = scanner.nextInt();
            scanner.nextLine();
        }

        Book book = LIST.get(index);
        System.out.println("请输入书籍名称");
        book.setTitle(scanner.nextLine());
        System.out.println("请输入作者名称");
        book.setAuthor(scanner.nextLine());
        System.out.println("请输入书籍价格");
        book.setPrice(scanner.nextInt());
        scanner.nextLine();

    }

    private static void delete(Scanner scanner) {
        scanner.nextLine();
        System.out.println("请输入你要删除的书籍编号");
        int index = scanner.nextInt();
        scanner.nextLine();
        while (index > LIST.size() - 1 || index < 0) {
            System.out.println("书籍标号不合法，请重新输入");
            index = scanner.nextInt();
            scanner.nextLine();
        }
        LIST.remove(index);
        System.out.println("删除书籍信息成功！");

    }
}







