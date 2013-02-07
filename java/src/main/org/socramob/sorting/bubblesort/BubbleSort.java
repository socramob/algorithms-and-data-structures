package org.socramob.sorting.bubblesort;

import org.socramob.sorting.UtilityFunctions;

import java.util.*;

public class BubbleSort {

    public static int[] sort(int[] numbers) {
        if (isOrdered(numbers)) {
            return numbers;
        }
        return sort(orderNeighbors(numbers));
    }

    private static boolean isOrdered(int[] numbers) {
        return Arrays.equals(numbers, orderNeighbors(numbers));
    }

    private static int[] orderNeighbors(int[] numbers) {
        int[] result = numbers.clone();
        for (int position = firstElement(); position < secondToLastElement(result); position++) {
            boolean neighborsAreInRightOrder = result[position] <= result[position + 1];
            if (!neighborsAreInRightOrder) {
                UtilityFunctions.swapPositions(result, position, position + 1);
            }
        }
        return result;
    }

    private static int firstElement() {
        return 0;
    }

    private static int secondToLastElement(int[] array) {
        return array.length - 1;
    }
}
