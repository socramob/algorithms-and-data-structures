package org.socramob.sorting.mergesort;

import org.socramob.lists.ArrayIntegerList;
import org.socramob.lists.IntegerList;

public class MergeSort {
    public static IntegerList sort(IntegerList numbers) {
        if(numbers.size() <= 1) {
            return numbers;
        }
        return merge(
                sort(numbers.firstHalf()),
                sort(numbers.secondHalf()));
    }

    public static IntegerList merge(IntegerList a, IntegerList b) {
        return merge(a.iterator(), b.iterator());
    }

    private static IntegerList merge(ArrayIntegerList.Iterator iteratorA, ArrayIntegerList.Iterator iteratorB) {
        IntegerList result = ArrayIntegerList.emptyList();

        while (iteratorA.elementAvailable() && iteratorB.elementAvailable()) {
            Integer elementOfA = iteratorA.getItem();
            Integer elementOfB = iteratorB.getItem();
            if (elementOfA < elementOfB) {
                result.append(elementOfA);
                iteratorA.proceed();
            } else {
                result.append(elementOfB);
                iteratorB.proceed();
            }
        }

        while (iteratorA.elementAvailable()) {
            result.append(iteratorA.getItem());
            iteratorA.proceed();
        }

        while (iteratorB.elementAvailable()) {
            result.append(iteratorB.getItem());
            iteratorB.proceed();
        }

        return result;
    }
}
