package org.example;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean isTrue = true;
        while (isTrue){
            System.out.println("do you want to encrypt (y) / (n)");
            String awnser = scan.nextLine();
            String response;
            if(awnser.equals("n")){
                isTrue = false;
            } else {
                System.out.print("string: ");
                String str = scan.nextLine();
                System.out.print("key: ");
                String key = scan.nextLine();

                System.out.println("(e): for encrypt\n(d): for decrypt");
                String cryptChose = scan.nextLine();
                if(cryptChose.equals("e")){
                    response = encrypt.encryptString(str, key);
                } else {
                    response = encrypt.decryptString(str, key);
                }
                System.out.println(response);
            }
        }
    }
}