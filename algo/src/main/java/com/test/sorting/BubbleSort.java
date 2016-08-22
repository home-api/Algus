package com.test.sorting;

import com.test.util.Util;

public class BubbleSort extends BaseSorting {

    public static void main(String[] args) {
        new BubbleSort(ARRAY_SIZE_DEAULT, MAX_ARRAY_INT_DEFAULT).sort();
    }

    private BubbleSort(int arraySize, int maxArrayInt) {
        super(arraySize, maxArrayInt);
    }

    @Override
    protected void arraySort(int[] array) {
        for (int i = array.length - 1; i > 1; i--) {
            addLoop();
            bubbleBiggestInt(array, i);
        }
    }

    private void bubbleBiggestInt(int[] array, int endIndex) {
        for (int k = 0; k < endIndex; k++) {
            addComparison();
            if (array[k] > array[k + 1]) {
                addSwap();
                Util.swap(array, k, k + 1);
            }
        }
    }

}
