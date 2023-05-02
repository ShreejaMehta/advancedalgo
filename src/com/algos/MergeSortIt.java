package com.algos;



import java.util.*;

public class MergeSortIt {
    private ArrayList<Integer> inputArray;

    // Constructor to initialize the input array
    public MergeSortIt(ArrayList<Integer> inputArray) {
        this.inputArray = inputArray;
    }

    // Getter method to return the sorted array
    public ArrayList<Integer> getSortedArray() {
        return inputArray;
    }

    // Method to sort the given array using an iterative approach
    public void sortGivenArray() {
        int size = inputArray.size();
        for (int currSize = 1; currSize < size; currSize *= 2) {
            for (int leftStart = 0; leftStart < size - 1; leftStart += 2 * currSize) {
                int mid = Math.min(leftStart + currSize - 1, size - 1);
                int rightEnd = Math.min(leftStart + 2 * currSize - 1, size - 1);
                merger(leftStart, mid, rightEnd);
            }
        }
    }

    // Method to merge two sorted subarrays
    public void merger(int startIndex, int midIndex, int endIndex) {
        ArrayList<Integer> mergedSortedArray = new ArrayList<Integer>();
        int leftIndex = startIndex;
        int rightIndex = midIndex + 1;

        // Compare elements from both subarrays and add the smaller one to the merged array
        while (leftIndex <= midIndex && rightIndex <= endIndex) {
            if (inputArray.get(leftIndex) <= inputArray.get(rightIndex)) {
                mergedSortedArray.add(inputArray.get(leftIndex));
                leftIndex++;
            } else {
                mergedSortedArray.add(inputArray.get(rightIndex));
                rightIndex++;
            }
        }

        // Add any remaining elements from the left subarray
        while (leftIndex <= midIndex) {
            mergedSortedArray.add(inputArray.get(leftIndex));
            leftIndex++;
        }

        // Add any remaining elements from the right subarray
        while (rightIndex <= endIndex) {
            mergedSortedArray.add(inputArray.get(rightIndex));
            rightIndex++;
        }

        // Copy the merged array back to the input array
        int i = 0;
        int j = startIndex;
        while (i < mergedSortedArray.size()) {
            inputArray.set(j, mergedSortedArray.get(i++));
            j++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();

        ArrayList<Integer> unsortedArray = new ArrayList<Integer>();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            unsortedArray.add(scanner.nextInt());
        }

        MergeSort ms = new MergeSort(unsortedArray);
        System.out.println("Unsorted array: " + ms.getSortedArray());

        ms.sortGivenArray();

        System.out.println("Sorted array: " + ms.getSortedArray());
    }
}
