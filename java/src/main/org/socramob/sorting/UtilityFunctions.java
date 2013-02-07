package org.socramob.sorting;

public class UtilityFunctions {
    public static void swapPositions(int[] numbers, int positionA, int positionB) {
        int temp = numbers[positionA];
        numbers[positionA] = numbers[positionB];
        numbers[positionB] = temp;
    }
}
