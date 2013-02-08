package org.socramob.sorting.selectionsort;

import org.socramob.lists.IntegerList;

public class SelectionSort {
    public static IntegerList sort(IntegerList numbers) {
        IntegerList sortedNumbers = IntegerList.copyOf(numbers);

        for (Integer nextPosition = sortedNumbers.firstPosition(); nextPosition <= sortedNumbers.secondToLastPosition(); nextPosition++) {
            Integer positionOfNextMinimum = selectPositionOfMinimumWithin(sortedNumbers, nextPosition, sortedNumbers.size() - 1);
            sortedNumbers.swapItemsAt(nextPosition, positionOfNextMinimum);
        }
        return sortedNumbers;
    }

    private static Integer selectPositionOfMinimumWithin(IntegerList numbers, Integer leftBoundary, Integer rightBoundary) {
        int positionOfMinimum = leftBoundary;
        for (int i = leftBoundary; i <= rightBoundary; i++) {
            if (numbers.get(i) < numbers.get(positionOfMinimum)) {
                positionOfMinimum = i;
            }
        }
        return positionOfMinimum;
    }

}
