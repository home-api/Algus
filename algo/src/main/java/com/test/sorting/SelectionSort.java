package com.test.sorting;

import com.test.util.Util;

public class SelectionSort extends BaseSorting {

    public static void main(String[] args) {
        new SelectionSort(ARRAY_SIZE_DEFAULT, MAX_ARRAY_INT_DEFAULT).sort();
    }

    private SelectionSort(int arraySize, int maxArrayInt) {
        super(arraySize, maxArrayInt);
    }

    @Override
    protected void arraySort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            addLoop();
            int smallestIndex = i;
            smallestIndex = getSmallestIndex(array, i, smallestIndex);
            addSwap();
            Util.swap(array, i, smallestIndex);
        }
    }

    private int getSmallestIndex(int[] array, int i, int smallestIndex) {
        for (int k = i + 1; k < array.length; k++) {
            addComparison();
            if (array[k] < array[smallestIndex]) {
                smallestIndex = k;
            }
        }
        return smallestIndex;
    }

}
