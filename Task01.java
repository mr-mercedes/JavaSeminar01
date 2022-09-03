package ru.seminar01;

/*
    1.  Задан массив, например, nums = [1,7,3,6,5,6].
        Написать программу, которая найдет индекс i для этого массива такой,
        что сумма элементов с индексами < i равна сумме элементов с индексами > i.
 */

public class Task01 {
    public static void main(String[] args) {
        int[] array = {10, 7, 3, 3, 3, 1};

        int findIndex = getIndex(array);

        System.out.printf(findIndex == -1 ? "Index not found" : "Find index is %d",findIndex);
    }

    private static int getIndex(int[] array) {
        int sumLeft = 0;
        int sumRight = 0;
        int findIndex = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (j < i) {
                    sumLeft += array[j];
                } else if (j > i) {
                    sumRight += array[j];
                }
            }
            if (sumRight == sumLeft) {
                findIndex = i;
                break;
            } else {
                sumLeft = 0;
                sumRight = 0;
                findIndex = -1;
            }
        }
        return findIndex;
    }
}
