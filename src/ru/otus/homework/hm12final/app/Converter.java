package ru.otus.homework.hm12final.app;


public class Converter {
    private static long number;
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static final long limit = 999_999_999_999L;

    public static String getNumberToWord(long number) {

        if (number > limit || number < 0){
            return "\"Введеное число превышает лимит \" + limit";
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
        stringBuilder.append(" ").append(Currency.RUBLES[reformer(number)]);
    }

    private static String formatToText(int quantity, boolean thousand) {
        int hundreds = quantity / 100;
        int tens = quantity % 100 / 10;
        int tensUnits = quantity % 100;
        int units = quantity % 10;

        if (isBetweenTens(tensUnits)) {
            return Words.HUNDREDS[hundreds] + " " + Words.BETWEEN_TENS[units];
        } else {
            if (thousand) {
                return Words.HUNDREDS[hundreds] + " " + Words.TENS[tens] + " " + Words.UNITS1[units];
            } else {
                return Words.HUNDREDS[hundreds] + " " + Words.TENS[tens] + " " + Words.UNITS[units];
            }
        }
    }
    private static void formatBillionPart(){
        int quantity = (int) (number / 1_000_000_000);
        if (quantity <= 0){
            return;
        }

        stringBuilder.append(formatToText(quantity, false)).append(" ").append(Words.BILLIONS[reformer(quantity)]).append(" "); //почему идея предлагает
                                                                                                                // изменить один append на серию вызовов?
    }
    private static void formatMillionPart(){
        int quantity = (int) (number % 1_000_000_000 / 1_000_000);
        if (quantity <= 0){
            return;
        }
        stringBuilder.append(formatToText(quantity, false)).append(" ").append(Words.MILLIONS[reformer(quantity)]).append(" ");
    }
    private static void formatThousandPart(){
        int quantity = (int) (number % 1_000_000_000 % 1_000_000 / 1000);
        if (quantity <= 0){
            return;
        }
        stringBuilder.append(formatToText(quantity, true)).append(" ").append(Words.THOUSANDS[reformer(quantity)]).append(" ");
    }
    private static void formatUnitPart(){
        int quantity = (int) (number % 1_000_000_000 % 1_000_000 % 1000);
        if (quantity <=0){
            return;
        }
        stringBuilder.append(formatToText(quantity, false));
    }




}
