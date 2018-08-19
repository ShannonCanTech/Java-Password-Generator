package com.company;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean invalidEntry = false;
        Scanner scan = new Scanner(System.in);
        int length;
        do {
            try {
                System.out.println("Enter the length of your password: ");
                length = scan.nextInt();
                scan.nextLine();
                System.out.println(generatePassword(length));
            } catch (InputMismatchException e) {
                invalidEntry = true;
                System.out.println("Invalid entry. Must be an integer");
            }
        } while (!invalidEntry);

    }

    static char[] generatePassword(int len) {
        System.out.println("Password: ");
        String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        String lower = "abcdefghijklmnopqrstuvwxyz";
        String lower = caps.toLowerCase();
        String nums = "0123456789";
        String symbols = "!@#$%^&*()_-+=/*<>?.%";

        String passSymbols = caps + lower + nums + symbols;
        Random rnd = new Random();

        char[] password = new char[len];
        for (int i = 0; i < len; i++) {
            password[i] = passSymbols.charAt(rnd.nextInt(passSymbols.length()));
        }

        return password;
    }

}
