package com.test.sorting;

import com.test.util.Util;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

abstract class BaseSorting {

    static final int ARRAY_SIZE_DEFAULT = 1000;
    static final int MAX_ARRAY_INT_DEFAULT = 1000;

    private static int loops = 0;
    private static int comparisons = 0;
    private static int swaps = 0;
    private static int allocations = 0;

    private final int arraySize;
    private final int maxArrayInt;

    BaseSorting(int arraySize, int maxArrayInt) {
        this.arraySize = arraySize;
        this.maxArrayInt = maxArrayInt;
    }

    void addLoop() {
        loops++;
    }

    void addComparison() {
        comparisons++;
    }

    void addSwap() {
        swaps++;
    }

    void addAllocations(int size) {
        allocations = allocations + size;
    }

    void sort() {
        int[] array = Util.generate(arraySize, maxArrayInt);

        System.out.println(Arrays.toString(array));

        System.out.println(this.getClass().getSimpleName());

        long startTime = Util.start();

        arraySort(array);

        System.out.println(
                "Sorting time: " + TimeUnit.NANOSECONDS.toMicros(Util.elapsedTime(startTime))
                        + " " + TimeUnit.MICROSECONDS.name());

        checkArray(array);

        printMetric("Loops", loops);
        printMetric("Comparisons", comparisons);
        printMetric("Swaps", swaps);
        printMetric("Allocations", allocations);

        System.out.println(Arrays.toString(array));
    }

    private void printMetric(String message, int metric) {
        if (metric > 0) {
            System.out.println(message + ": " + metric);
        }
    }

    protected abstract void arraySort(int[] array);

    private void checkArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                throw new RuntimeException(
                        "array order is incorrect:"
                                + " index " + (i - 1) + " (" + array[i - 1] + ")"
                                + " is bigger than "
                                + "index " + (i) + " (" + array[i] + ")");
            }
        }
    }

}
