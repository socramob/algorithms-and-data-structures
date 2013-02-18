package org.socramob.algorithms.sorting.mergesort;

import org.socramob.abstractdatastructures.lists.ArrayIntegerList;
import org.socramob.abstractdatastructures.lists.IntegerList;
import org.socramob.abstractdatastructures.lists.IntegerListIterator;

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

    private static IntegerList merge(IntegerListIterator iteratorA, IntegerListIterator iteratorB) {
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
