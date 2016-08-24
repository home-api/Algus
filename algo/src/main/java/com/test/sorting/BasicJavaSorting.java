package com.test.sorting;

import java.util.Arrays;

public class BasicJavaSorting extends BaseSorting {

    public static void main(String[] args) {
        new BasicJavaSorting(ARRAY_SIZE_DEFAULT, MAX_ARRAY_INT_DEFAULT).sort();
    }

    BasicJavaSorting(int arraySize, int maxArrayInt) {
        super(arraySize, maxArrayInt);
    }

    @Override
    protected void arraySort(int[] array) {
        Arrays.sort(array);
    }
}
