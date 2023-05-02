import com.algos.*;

import java.util.Scanner;

public class Main {

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
