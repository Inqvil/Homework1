package ru.otus.homework.hm12final.app;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

 public class Menu {
    public static void menu(){

        boolean exit = false;

        try (Scanner sc = new Scanner(System.in)){
            try {
                String menu = "1.Сменить валюту. 2. Конвертировать число в пропись. 3. Выйти";
                while (!exit) {
                    System.out.println(menu);
                    int choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println(Currency.availableCurrency);
                            int currencyChoice = sc.nextInt();
                            Converter.currencySwitcher(currencyChoice);
                            break;
                        case 2:
                            System.out.println("введите любое число до триллиона");
                            long number = sc.nextLong();
                            System.out.println(Converter.getNumberToWord(number));
                            if (number == 0) {
                                break;
                            }
                            break;

                        case 3:
                            exit = true;
                            break;
                        default:
                            System.out.println("некорректный ввод");
                    }
                }
            }catch (NoSuchElementException noSuchElementException){
                System.out.println("некорректный ввод");
                menu();
            }

        }catch (InputMismatchException InputMismatchException){
            System.out.println("Введено не целое число");
            menu();
        }

    }



}
