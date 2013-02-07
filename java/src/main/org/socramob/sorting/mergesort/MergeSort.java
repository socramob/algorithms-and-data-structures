package org.socramob.sorting.mergesort;

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
        Integer i = 0, j = 0;
        IntegerList result = IntegerList.emptyList();

        while ((i < a.size()) && (j < b.size())) {
            if (a.get(i) < b.get(j))
                result.append(a.get(i++));
            else
                result.append(b.get(j++));
        }

        while (i < a.size()) result.append(a.get(i++));
        while (j < b.size()) result.append(b.get(j++));

        return result;
    }
}
