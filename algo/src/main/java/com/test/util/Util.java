package com.test.util;

import java.util.Random;

public class Util {

    private static final Random GENERATOR = new Random();

    public static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    public static int[] generate(int size, int maxInt) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = GENERATOR.nextInt(maxInt);
        }
        return array;
    }

    public static long start() {
        return System.nanoTime();
    }

    public static long elapsedTime(long startTime) {
        return System.nanoTime() - startTime;
    }

}
