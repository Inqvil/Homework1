package ru.otus.homework.hm12final.app;


public class Converter {
    private static long number;
    private static int currencySwitcher;
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static final long limit = 999_999_999_999L;

    public static String getNumberToWord(long number) {

        if (number > limit | number < 0){
            return "Введеное число превышает лимит "   + limit;
        }
        Converter.number = number;

        stringBuilder.replace(0, stringBuilder.length(), "");
        formatBillionPart();
        formatMillionPart();
        formatThousandPart();
        formatUnitPart();
        addCurrency();
        removeWhiteSpaces(stringBuilder);
        return stringBuilder.toString().trim();

    }
    public static void currencySwitcher(int choice){
        Converter.currencySwitcher = choice;
    }


    private static boolean isBetweenTens(int number) {
        return number > 10 && number < 20;
    }

    private static int reformer(long number) { //https://ru.stackoverflow.com/questions/674732
        int lastDigit = (int) (number % 10);
        int twoLastDigits = (int) (number % 100);

        if (lastDigit == 1 & twoLastDigits != 11) {
            return 1;
        }
        if ((lastDigit >= 2 && lastDigit <= 4) && !isBetweenTens(twoLastDigits)) {
            return 2;
        } else {
            return 3;
        }
    }
    private static void removeWhiteSpaces(StringBuilder sb) {
        int end = 0;
        int spaceIndex = -1;

        for (int i = 0; i < sb.length(); i++) {
            if (!Character.isWhitespace(sb.charAt(i))) {
                sb.setCharAt(end++, sb.charAt(i));
                spaceIndex = -1;
            } else if (spaceIndex < 0) {
                sb.setCharAt(end++, sb.charAt(i));
                spaceIndex = i;
            }
        }

        sb.setLength(end);
    }
    private static void addCurrency(){

        if (number == 0){
            return;
        }
        switch (currencySwitcher){
            case 1:
                stringBuilder.append(" ").append(Currency.getCurrency(1, reformer(number)));
                break;
            case 2:
                stringBuilder.append(" ").append(Currency.getCurrency(2, reformer(number)));
                break;
            case 3:
                stringBuilder.append(" ").append(Currency.getCurrency(3, reformer(number)));
                break;
            case 4:
                stringBuilder.append(" ").append(Currency.getCurrency(4, reformer(number)));
                break;
            default:
                stringBuilder.append(" ").append(Currency.getCurrency(1, reformer(number)));



        }
    }

    private static String formatToText(int quantity, boolean thousand) {
        int hundreds = quantity / 100;
        int tens = quantity % 100 / 10;
        int tensUnits = quantity % 100;
        int units = quantity % 10;

        if (isBetweenTens(tensUnits)) {
            return Words.getWord(5, hundreds) + " " + Words.getWord(3, units);
        } else {
            if (thousand) {
                return Words.getWord(5, hundreds)+ " " + Words.getWord(4, tens) + " " + Words.getWord(2, units);
            } else {
                return Words.getWord(5, hundreds)+ " " + Words.getWord(4, tens) + " " + Words.getWord(1, units);
            }
        }
    }
    private static void formatBillionPart(){
        int quantity = (int) (number / 1_000_000_000);
        if (quantity <= 0){
            return;
        }

        stringBuilder.append(formatToText(quantity, false)).append(" ").append(Words.getWord(8, reformer(quantity))).append(" "); //почему идея предлагает
                                                                                                                // изменить один append на серию вызовов?
    }
    private static void formatMillionPart(){
        int quantity = (int) (number % 1_000_000_000 / 1_000_000);
        if (quantity <= 0){
            return;
        }
        stringBuilder.append(formatToText(quantity, false)).append(" ").append(Words.getWord(7, reformer(quantity))).append(" ");
    }
    private static void formatThousandPart(){
        int quantity = (int) (number % 1_000_000_000 % 1_000_000 / 1000);
        if (quantity <= 0){
            return;
        }
        stringBuilder.append(formatToText(quantity, true)).append(" ").append(Words.getWord(6, reformer(quantity))).append(" ");
    }
    private static void formatUnitPart(){
        int quantity = (int) (number % 1_000_000_000 % 1_000_000 % 1000);
        if (quantity <=0){
            return;
        }
        stringBuilder.append(formatToText(quantity, false));
    }




}
