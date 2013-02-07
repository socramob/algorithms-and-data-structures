package org.socramob.sorting;

public class UtilityFunctions {
    public static void swapPositions(int[] numbers, int positionA, int positionB) {
        int temp = numbers[positionA];
        numbers[positionA] = numbers[positionB];
        numbers[positionB] = temp;
    }

    public static int firstElement() {
        return 0;
    }

    public static int secondToLastElement(int[] array) {
        return array.length - 1;
    }

    public static int lastElement(Object[] array) {
        return array.length - 1;
    }
}
