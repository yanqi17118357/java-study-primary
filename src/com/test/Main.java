package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File source = new File(".");
        File destination = new File("../dest");

        if (!destination.exists()) {
            destination.mkdir();
        }

        copyFolder(source, destination);
    }

    private static void copyFolder(File source, File destination) throws IOException {
        if (source.isDirectory()) {
            if (!destination.exists()) {
                destination.mkdir();
            }

            String[] strings = source.list();
            for (String string : strings) {
                // 此方法是根据子路径名和父File对象创建子File对象
                File src = new File(source, string);
                File dest = new File(destination, string);
                copyFolder(src, dest);
                System.out.println(string);
            }
        } else {
            try (FileInputStream inputStream = new FileInputStream(source);
                 FileOutputStream outputStream = new FileOutputStream(destination)) {
                byte[] bytes = new byte[1024];
                int len;
                while ((len = inputStream.read(bytes)) > 0) {
                    outputStream.write(bytes, 0, len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}







