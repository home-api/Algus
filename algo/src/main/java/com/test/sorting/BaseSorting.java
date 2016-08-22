package com.test.sorting;

import com.test.util.Util;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public abstract class BaseSorting {

    static final int ARRAY_SIZE_DEAULT = 1000;
    static final int MAX_ARRAY_INT_DEFAULT = 1000;

    private static int loops = 0;
    private static int comparisons = 0;
    private static int swaps = 0;

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

    void sort() {
        int[] array = Util.generate(arraySize, maxArrayInt);

        System.out.println(Arrays.toString(array));

        System.out.println(this.getClass().getSimpleName());

        long startTime = Util.start();

        arraySort(array);

        System.out.println("Sorting time: " + TimeUnit.NANOSECONDS.toMicros(Util.elapsedTime(startTime)));

        System.out.println("Loops: " + loops);
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);

        System.out.println(Arrays.toString(array));
    }

    protected abstract void arraySort(int[] array);

}
