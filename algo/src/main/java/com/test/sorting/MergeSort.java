package com.test.sorting;

import java.util.Arrays;

public class MergeSort extends BaseSorting {

    public static void main(String[] args) {
        new MergeSort(ARRAY_SIZE_DEFAULT, MAX_ARRAY_INT_DEFAULT).sort();
    }

    private MergeSort(int arraySize, int maxArrayInt) {
        super(arraySize, maxArrayInt);
    }

    @Override
    protected void arraySort(int[] array) {
        System.arraycopy(sort(array), 0, array, 0, array.length);
    }

    private int[] sort(int[] array) {
        addLoop();

        int middle = array.length / 2;
        int[] a = Arrays.copyOfRange(array, 0, middle);
        int[] b = Arrays.copyOfRange(array, middle, array.length);

        if (a.length > 1) {
            a = sort(a);
        }

        if (b.length > 1) {
            b = sort(b);
        }

        return merge(a, b);
    }

    private int[] merge(int[] a, int[] b) {
        int newSize = a.length + b.length;
        addAllocations(newSize);
        int[] newArray = new int[newSize];

        int i = 0;
        int indexA = 0;
        int indexB = 0;

        while (indexA < a.length && indexB < b.length) {
            addComparison();
            addSwap();
            if (a[indexA] < b[indexB]) {
                newArray[i] = a[indexA];
                indexA++;
            } else {
                newArray[i] = b[indexB];
                indexB++;
            }
            i++;
        }

        if (indexA < a.length) {
            appendToTheEnd(newArray, i, a, indexA);
        } else {
            appendToTheEnd(newArray, i, b, indexB);
        }

        return newArray;
    }

    private void appendToTheEnd(int[] destination, int destinationStartIndex, int[] source, int sourceStartIndex) {
        for (int j = sourceStartIndex; j < source.length; j++) {
            addSwap();
            destination[destinationStartIndex] = source[j];
            destinationStartIndex++;
        }
    }
}
