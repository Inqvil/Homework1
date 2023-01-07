package ru.otus.homework.hm12final.tests.assertions;

public class MyAssert {
    public static void assertEquals (String excepted, String actual){
        if (!excepted.equals(actual)){
            throw new AssertionError(excepted + "!= " + actual);
        }
        else {
            System.out.println(excepted + " == " + actual);
        }

    }
}
