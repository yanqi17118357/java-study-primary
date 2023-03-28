package com.test;


import java.io.*;


public class Main {
    public static void main(String[] args) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("output.txt"));
             ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("output.txt"))){
            People people = new People("lbw");
            outputStream.writeObject(people);
            outputStream.flush();
            people = (People) inputStream.readObject();
            System.out.println(people.name);  //虽然能得到对象，但是name属性并没有保存，因此为null
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static class People implements Serializable{
        private static final long serialVersionUID = 1234567;

        transient String name;

        public People(String name){
            this.name = name;
        }
    }
}







