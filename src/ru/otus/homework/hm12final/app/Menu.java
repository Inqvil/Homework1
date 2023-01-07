package ru.otus.homework.hm12final.app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void menu(){
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        System.out.println("Введите любое целое число до триллиона, для выхода ввести 0");
        try {

            while (!exit) {
                long number = sc.nextLong();
                Converter.getNumberToWord(number);
                System.out.println(Converter.getNumberToWord(number));
                if (number == 0) {
                    exit = true;
                }
            }
        }catch (InputMismatchException InputMismatchException){
            System.out.println("Введено не целое число");
            menu();
        }

    }

}
