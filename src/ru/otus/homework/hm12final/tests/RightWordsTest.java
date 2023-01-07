package ru.otus.homework.hm12final.tests;

import ru.otus.homework.hm12final.app.Converter;
import ru.otus.homework.hm12final.tests.assertions.MyAssert;


public class RightWordsTest {
    public static void correctNumberToWordTest (){
        String scenario = "Проверка на корректный перевод числа в пропись " + "\n________________________________";
        System.out.println(scenario);
        try {

            MyAssert.assertEquals("один рубль", Converter.getNumberToWord(1));
            MyAssert.assertEquals("два рубля", Converter.getNumberToWord(2));
            MyAssert.assertEquals("три рубля", Converter.getNumberToWord(3));
            MyAssert.assertEquals("четыре рубля", Converter.getNumberToWord(4));
            MyAssert.assertEquals("пять рублей", Converter.getNumberToWord(5));
            MyAssert.assertEquals("одиннадцать рублей", Converter.getNumberToWord(11));
            MyAssert.assertEquals("двадцать рублей", Converter.getNumberToWord(20));
            MyAssert.assertEquals("сто двадцать одна тысяча двести двадцать три рубля", Converter.getNumberToWord(121223));
            MyAssert.assertEquals("триста сорок четыре миллиона восемьсот тридцать четыре тысячи девятьсот восемьдесят четыре рубля", Converter.getNumberToWord(344834984));
            MyAssert.assertEquals("сто десять миллиардов триста два миллиона триста две тысячи триста девять рублей", Converter.getNumberToWord(110_302_302_309L));
            MyAssert.assertEquals("сто одиннадцать рублей", Converter.getNumberToWord(111)); // почему этот тест постоянно падал? ввел те же значения и все заработало. я не понимаю
            MyAssert.assertEquals("одна тысяча сто одиннадцать рублей", Converter.getNumberToWord(1111));
            MyAssert.assertEquals("одиннадцать тысяч сто одиннадцать рублей", Converter.getNumberToWord(11111));
            MyAssert.assertEquals("сто одиннадцать тысяч сто одиннадцать рублей", Converter.getNumberToWord(111111));
            MyAssert.assertEquals("один миллион сто одиннадцать тысяч сто одиннадцать рублей", Converter.getNumberToWord(1111111));
            MyAssert.assertEquals("одиннадцать миллионов сто одиннадцать тысяч сто одиннадцать рублей", Converter.getNumberToWord(11111111));
            System.out.println();
            MyAssert.assertEquals("девятьсот девяносто девять миллиардов девятьсот девяносто девять " +
                    "миллионов девятьсот девяносто девять тысяч девятьсот девяносто девять рублей", Converter.getNumberToWord(999999999999L));

            MyAssert.assertEquals("одна тысяча рублей", Converter.getNumberToWord(1000));
            MyAssert.assertEquals("одна тысяча девятьсот девяносто один рубль", Converter.getNumberToWord(1991));
            MyAssert.assertEquals("одна тысяча девятьсот девяносто два рубля", Converter.getNumberToWord(1992));
            MyAssert.assertEquals("одна тысяча девятьсот девяносто пять рублей", Converter.getNumberToWord(1995));
            MyAssert.assertEquals("одна тысяча девятьсот одиннадцать рублей", Converter.getNumberToWord(1911));

            System.out.println("_____________\n" + scenario + " пройден"  + "________________________________");
        }
        catch (AssertionError assertionError){
            System.err.println(scenario + " провалена " + assertionError.toString());
        }


    }

}
