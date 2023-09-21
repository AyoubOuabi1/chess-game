package com.ayoub.chess.prints;

import java.util.Scanner;

public class PrintMessages {

    public static  String printFirstMessage(){
        System.out.println("Welcome to Chess game!");
        System.out.println("Please enter your name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        return name;
    }
}
