package ru.seminar01;

/*
    2. Напишите функцию, для поиска наиболее длинного общего префикса, среди массива строк.
    Если общего префикса нет, то возвращать пустую строку.
    Пример ["aabb", "aabbb", "aaabb"] - ответ "aa"
 */

import java.util.Arrays;

public class Task02 {
    public static void main(String[] args) {
        String[] array = {"abb", "aabbb", "aaabb", "aaaabbb", "aaabb"};

        System.out.print("In array " + Arrays.toString(array));
        System.out.println(" longest prefix = " + getPrefix(array));
    }

    private static String getPrefix(String[] array) {
        String[] stringArray = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            String tmp = array[i];
            StringBuilder builder = new StringBuilder(tmp.charAt(0));
            for (int j = 0; j < tmp.length() - 1; j++) {
                if (tmp.charAt(0) == tmp.charAt(j)) {
                    builder.append(tmp.charAt(0));
                }
            }
            stringArray[i] = builder.toString();
            builder.setLength(0);
        }

        return longestPrefix(stringArray);


    }

    private static String longestPrefix(String[] stringArray) {
        int count = 1;
        for (int i = 0; i < stringArray.length; i++) {
            for (int j = i + 1; j < stringArray.length; j++) {
                if (stringArray[i].equals(stringArray[j])) {
                    count++;
                }
            }
            if (count >= (stringArray.length - count) / 2) {
                return stringArray[i];
            }
            count = 1;
        }
        return "empty string";
    }
}
