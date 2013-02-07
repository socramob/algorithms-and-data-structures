package org.socramob.sorting.mergesort;

import org.socramob.sorting.UtilityFunctions;

import java.util.*;

public class MergeSort {
    public static Integer[] sort(Integer[] numbers) {
        Integer[][] subsequences = splitIntoSubsequences(numbers);
        while (subsequences.length > 1) {
            if(!even(subsequences.length)) {
                subsequences = Arrays.copyOf(subsequences, subsequences.length + 1);
                subsequences[UtilityFunctions.lastElement(subsequences)] = new Integer[0];
            }
            Integer[][] mergedSubsequences = new Integer[subsequences.length / 2][0];
            for (Integer i = UtilityFunctions.firstElement(); i < UtilityFunctions.lastElement(subsequences); i += 2) {
                mergedSubsequences[i / 2] = merge(subsequences[i], subsequences[i + 1]);
            }
            subsequences = mergedSubsequences;
        }
        return subsequences[0];
    }

    private static boolean even(Integer n) {
        return n % 2 == 0;
    }

    private static Integer[][] splitIntoSubsequences(Integer[] numbers) {
        Integer[][] result = new Integer[max(1, numbers.length)][0];
        for(Integer i = UtilityFunctions.firstElement(); i <= UtilityFunctions.lastElement(numbers); i++) {
            result[i] = new Integer[] { numbers[i] };
        }
        return result;
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static Integer[] merge(Integer[] a, Integer[] b) {
        Integer i = 0, j = 0, k = 0;
        Integer[] result = new Integer[a.length + b.length];

        while ((i < a.length) && (j < b.length)) {       // mischen, bis ein Array leer
            if (a[i] < b[j])                           // jeweils das kleinere Element
                result[k++] = a[i++];                       // wird nach result uebernommen
            else
                result[k++] = b[j++];
        }

        while (i < a.length) result[k++] = a[i++];          // ggf.: Rest von Folge a
        while (j < b.length) result[k++] = b[j++];          // ggf.: Rest von Folge b

        return result;                                    // Ergebnis abliefern
    }
}
