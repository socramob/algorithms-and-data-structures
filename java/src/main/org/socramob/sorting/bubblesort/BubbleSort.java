package org.socramob.sorting.bubblesort;

import org.socramob.lists.IntegerList;

public class BubbleSort {

    public static IntegerList sort(IntegerList numbers) {
        if (isOrdered(numbers)) {
            return numbers;
        }
        return sort(orderNeighbors(numbers));
    }

    private static boolean isOrdered(IntegerList numbers) {
        return numbers.equals(orderNeighbors(numbers));
    }

    private static IntegerList orderNeighbors(IntegerList numbers) {
        IntegerList result = IntegerList.copyOf(numbers);
        for (int position = result.firstPosition(); position <= result.secondToLastPosition(); position++) {
            boolean neighborsAreInRightOrder = (result.get(position) <= result.get(successor(position)));
            if (!neighborsAreInRightOrder) {
                result.swapItemsAt(position, successor(position));
            }
        }
        return result;
    }

    private static Integer successor(Integer position) {
        return position + 1;
    }

}
