package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        System.out.printf("welcome to jms demp");
        JmsSender sender = new JmsSender();
        JmsReciever reciever = new JmsReciever();
       // sender.showData();
        reciever.showData();
    }
}