package com.algos;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner; // Import Scanner class for user input

public class QuickSort {

    private ArrayList<Integer> inputArray;

    public QuickSort(ArrayList<Integer> inputArray) {
        this.inputArray = inputArray;
    }

    // Main quick sort function
    public void startQuickSort(int start, int end) {
        int q;
        if (start < end) {
            q = partition(start, end);
            startQuickSort(start, q);
            startQuickSort(q + 1, end);
        }
    }

    // Getter for the sorted array
    public ArrayList<Integer> getSortedArray() {
        return inputArray;
    }

    // Partition function used in quick sort
    public int partition(int start, int end) {
        int init = start;
        int length = end;
        Random r = new Random();
        int pivotIndex = nextIntInRange(start, end, r);
        int pivot = inputArray.get(pivotIndex);

        while (true) {
            while (inputArray.get(length) > pivot && length > start) {
                length--;
            }
            while (inputArray.get(init) < pivot && init < end) {
                init++;
            }

            if (init < length) {
                int temp;
                temp = inputArray.get(init);
                inputArray.set(init, inputArray.get(length));
                inputArray.set(length, temp);
                length--;
                init++;
            } else {
                return length;
            }
        }
    }

    // Helper function to get a random integer within a specified range
    static int nextIntInRange(int min, int max, Random rng) {
        if (min > max) {
            throw new IllegalArgumentException("Cannot draw random int from invalid range [" + min + ", " + max + "].");
        }
        int diff = max - min;
        if (diff >= 0 && diff != Integer.MAX_VALUE) {
            return (min + rng.nextInt(diff + 1));
        }
        int i;
        do {
            i = rng.nextInt();
        } while (i < min || i > max);
        return i;
    }

    public static void main(String[] args) {
        ArrayList<Integer> unsortedArray = new ArrayList<Integer>();

        // Take user input for array elements
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            unsortedArray.add(sc.nextInt());
        }
        sc.close();

        QuickSort qsu = new QuickSort(unsortedArray);

        qsu.startQuickSort(0, unsortedArray.size() - 1);

        // Print the sorted array
        System.out.println("Sorted Array:");
        for (int i : qsu.getSortedArray()) {
            System.out.print(i + " ");
        }
    }
}
