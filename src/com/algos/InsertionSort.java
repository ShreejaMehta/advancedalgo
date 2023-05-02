package com.algos;
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

}
