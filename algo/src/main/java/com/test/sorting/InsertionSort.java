package com.test.sorting;

public class InsertionSort extends BaseSorting {

    public static void main(String[] args) {
        new InsertionSort(ARRAY_SIZE_DEFAULT, MAX_ARRAY_INT_DEFAULT).sort();
    }

    private InsertionSort(int arraySize, int maxArrayInt) {
        super(arraySize, maxArrayInt);
    }

    @Override
    protected void arraySort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            addLoop();
            int currentValue = array[i];
            int insertIndex = getIndexToInsert(array, i, currentValue);
            addSwap();
            array[insertIndex] = currentValue;
        }
    }

    private int getIndexToInsert(int[] array, int i, int currentValue) {
        int insertIndex = i;
        for (int k = i - 1; k >= 0; k--) {
            addComparison();
            if (array[k] > currentValue) {
                array[k + 1] = array[k];
                insertIndex = k;
            } else {
                break;
            }
        }
        return insertIndex;
    }
}
