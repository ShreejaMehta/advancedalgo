package com.algos;

import java.util.Arrays;

public class ParallelSum {
    private static int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Input array
    private static int numberOfProcessors = 4; // Number of processors

    public static void main(String[] args) {
        int sum = parallelSum(array);
        System.out.println("Sum: " + sum);
    }

    public static int parallelSum(int[] array) {
        int chunkSize = array.length / numberOfProcessors;
        int[][] chunks = splitArray(array, chunkSize);
        int[] partialSums = new int[numberOfProcessors];

        Thread[] threads = new Thread[numberOfProcessors];

        for (int i = 0; i < numberOfProcessors; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                int localSum = 0;
                for (int j = 0; j < chunks[index].length; j++) {
                    localSum += chunks[index][j];
                }
                partialSums[index] = localSum;
            });
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int totalSum = 0;
        for (int partialSum : partialSums) {
            totalSum += partialSum;
        }

        return totalSum;
    }

    private static int[][] splitArray(int[] array, int chunkSize) {
        int[][] chunks = new int[numberOfProcessors][chunkSize];

        for (int i = 0; i < numberOfProcessors; i++) {
            chunks[i] = Arrays.copyOfRange(array, i * chunkSize, (i + 1) * chunkSize);
        }

        return chunks;
    }
}
