package com.algos;

import java.util.Scanner;

public class InsertionSort {

    public void insertionSortrec(int [] arr, int i, int n)
    {
        int val = arr[i];
        int j = i;

        while( j>0 && arr[j-1]> val)
        {
            arr[j] = arr[j-1];
            j--;
        }

        arr[j] = val;

        if(i+1<=n)
        {
            insertionSortrec(arr, i+1, n);
        }
    }
    public int[] insertionSortit(int [] arr){

        int j=0;
        int len= arr.length;
        for(int i=1; i<len; i++)
        {
            int val = arr[i];
            j= i-1;
            boolean done = false;
            while(!done)
            {
                if(arr[j]>val)
                {
                    arr[j+1] = arr[j];
                    j=j-1;
                    if(j<0) {
                        done = true;
                    }
                }
                else
                {
                    done =true;
                }
            }

            arr[j+1] = val;
        }

        return arr;
    }
    public static void main(String[] args) {
        // write your code here
        InsertionSort ins = new InsertionSort();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of elements to be sorted:");
        int size = scan.nextInt();
        int [] arr = new int[size];
        int [] arr1 = new int[size];
        System.out.println("Enter elements");
        for(int i=0; i<=size-1; i++)
        {
            arr[i]=scan.nextInt();
            arr1[i] = arr[i];
        }
        System.out.println("Sorted array is:");
        System.out.println("Using Iteration:");
        arr= ins.insertionSortit(arr);
        for(int m=0; m<=size-1;m++)
        {
            System.out.print(arr[m] +" ");
        }
        System.out.println("\n");
        System.out.println("Using Recursion:");
        ins.insertionSortrec(arr1, 1, size-1);
        for(int m=0; m<=size-1;m++)
        {
            System.out.print(arr1[m] +" ");
        }
    }

}
