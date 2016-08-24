package com.test.sorting;

import com.test.util.Util;

public class QuickSort extends BaseSorting {

    public static void main(String[] args) {
        new QuickSort(ARRAY_SIZE_DEFAULT, MAX_ARRAY_INT_DEFAULT).sort();
    }

    private QuickSort(int arraySize, int maxArrayInt) {
        super(arraySize, maxArrayInt);
    }

    @Override
    protected void arraySort(int[] array) {
        sortArray(array, 0, array.length - 1);
    }

    private void sortArray(int[] array, int start, int end) {
        addLoop();
        if (end - start >= 1) {
            int right = partition(array, start, end);
            sortArray(array, start, right - 1);
            sortArray(array, right + 1, end);
        }
    }

    private int partition(int[] array, int start, int end) {
        int pivot = array[start];
        int left = start;
        int right = end;

        while (left < right) {
            addComparison();
            // 1st operand is to check which element to swap
            // 2nd operand is to stop if another loop has check right side of the array
            // 3rd operand is to prevent IndexOutOfBoundException
            while (array[left] <= pivot && left < right && left <= end) {
                left++;
            }

            // 1st operand is to check which element to swap
            // 2nd operand is to prevent infinite swapping if two adjacent elements are bigger than pivot
            // 3rd operand is to prevent IndexOutOfBoundException
            while (array[right] > pivot && right >= left && right >= start) {
                right--;
            }

            if (left < right) {
                addSwap();
                Util.swap(array, left, right);
            }
        }

        addSwap();
        Util.swap(array, start, right);

        return right;
    }
}
