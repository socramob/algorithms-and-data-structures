package org.socramob.algorithms.sorting.selectionsort;

import org.socramob.abstractdatastructures.lists.ArrayIntegerList;
import org.socramob.abstractdatastructures.lists.IntegerList;

public class SelectionSort {
    public static IntegerList sort(IntegerList numbers) {
        IntegerList sortedNumbers = ArrayIntegerList.copyOf(numbers);

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
