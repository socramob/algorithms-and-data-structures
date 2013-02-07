package org.socramob.sorting.selectionsort;

import org.socramob.sorting.UtilityFunctions;

public class SelectionSort {
    public static int[] sort(int[] numbers) {
        int[] sortedNumbers = numbers.clone();

        for (int nextPosition = 0; nextPosition < sortedNumbers.length - 1; nextPosition++) {
            int positionOfNextMinimum = positionOfMinimumWithin(sortedNumbers, nextPosition, sortedNumbers.length - 1);
            UtilityFunctions.swapPositions(sortedNumbers, nextPosition, positionOfNextMinimum);
        }
        return sortedNumbers;
    }

    private static int positionOfMinimumWithin(int[] numbers, int leftBoundary, int rightBoundary) {
        int positionOfMinimum = leftBoundary;
        for (int i = leftBoundary; i <= rightBoundary; i++) {
            if (numbers[i] < numbers[positionOfMinimum]) {
                positionOfMinimum = i;
            }
        }
        return positionOfMinimum;
    }

}
