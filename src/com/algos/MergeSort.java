package com.algos;

import java.util.*;

public class MergeSort {
    private ArrayList<Integer> inputArray;

    // Getter method to return the sorted array
    public ArrayList<Integer> getSortedArray() {
        return inputArray;
    }

    // Method to sort the given array using merge sort
    public void sortGivenArray() {
        divide(0, this.inputArray.size() - 1);
    }

    // Constructor to initialize the input array
    public MergeSort(ArrayList<Integer> inputArray) {
        this.inputArray = inputArray;
    }

    // Method to divide the array recursively
    public void divide(int startIndex, int endIndex) {
        if (startIndex < endIndex && (endIndex - startIndex) >= 1) {
            int mid = (endIndex + startIndex) / 2;
            divide(startIndex, mid);
            divide(mid + 1, endIndex);
            merger(startIndex, mid, endIndex);
        }
    }

    // Method to merge divided arrays in sorted order
    public void merger(int startIndex, int midIndex, int endIndex) {
        ArrayList<Integer> mergedSortedArray = new ArrayList<Integer>();
        int leftIndex = startIndex;
        int rightIndex = midIndex + 1;

        while (leftIndex <= midIndex && rightIndex <= endIndex) {
            if (inputArray.get(leftIndex) <= inputArray.get(rightIndex)) {
                mergedSortedArray.add(inputArray.get(leftIndex));
                leftIndex++;
            } else {
                mergedSortedArray.add(inputArray.get(rightIndex));
                rightIndex++;
            }
        }

        while (leftIndex <= midIndex) {
            mergedSortedArray.add(inputArray.get(leftIndex));
            leftIndex++;
        }

        while (rightIndex <= endIndex) {
            mergedSortedArray.add(inputArray.get(rightIndex));
            rightIndex++;
        }

        int i = 0;
        int j = startIndex;
        while (i < mergedSortedArray.size()) {
            inputArray.set(j, mergedSortedArray.get(i++));
            j++;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> unsortedArray = new ArrayList<Integer>();

        // Take user input for the array
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            unsortedArray.add(sc.nextInt());
        }
        sc.close();

        MergeSort ms = new MergeSort(unsortedArray);
        System.out.println("Unsorted array");
        for (int i : ms.getSortedArray()) {
            System.out.print(i + " ");
        }

        ms.sortGivenArray();

        System.out.println("\nSorted array");
        for (int i : ms.getSortedArray()) {
            System.out.print(i + " ");
        }
    }
}
