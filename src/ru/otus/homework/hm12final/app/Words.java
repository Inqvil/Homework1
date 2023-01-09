package ru.otus.homework.hm12final.app;

public class Words {
    /*1 - units
      2 - units1
      3 - BETWEEN_TENS
      4 - TENS
      5 - HUNDREDS
      6 - THOUSANDS
      7 - MILLIONS
      8 - BILLIONS
      */

    private static final String[] UNITS = {"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};
    private static final String[] UNITS1 = {"", "одна", "две", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};

    private static final String[] BETWEEN_TENS = {"", "одиннадцать", "двенадцать",
            "тринадцать", "четырнадцать",
            "пятнадцать", "шестнадцать",
            "семнадцать", "восемнадцать",
            "девятнадцать"};

    private static final String[] TENS = {"", "десять", "двадцать", "тридцать",
            "сорок", "пятьдесят", "шестьдесят",
            "семьдесять", "восемьдесят", "девяносто"};

    private static final String[] HUNDREDS = {"", "сто", "двести", "триста",
            "четыреста", "пятьсот", "шестьсот",
            "семьсот", "восемьсот", "девятьсот"};

    private static final String[] THOUSANDS = {"", "тысяча", "тысячи", "тысяч"};
    private static final String[] MILLIONS = {"", "миллион", "миллиона", "миллионов"};
    private static final String[] BILLIONS = {"", "миллиард", "миллиарда", "миллиардов"};

    public static String getWord(int massiveIndex, int index){
        return switch (massiveIndex) {
            case 1 -> UNITS[index];
            case 2 -> UNITS1[index];
            case 3 -> BETWEEN_TENS[index];
            case 4 -> TENS[index];
            case 5 -> HUNDREDS[index];
            case 6 -> THOUSANDS[index];
            case 7 -> MILLIONS[index];
            case 8 -> BILLIONS[index];
            default -> "еще не добавлено";
        };
    }
}
