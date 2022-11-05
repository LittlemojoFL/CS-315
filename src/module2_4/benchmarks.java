/*
 * Author: Logan McClellan
 * Date: 11/04/2022
 * Description: Implementing Selection and QuickSort algorithms and evaluating their runtimes with
 *              variety of array types.
 *
 * References: https://algs4.cs.princeton.edu/14analysis/
 *             https://algs4.cs.princeton.edu/14analysis/Stopwatch.java.html
 *             https://www.geeksforgeeks.org/java-program-for-quicksort/
 *             https://www.javatpoint.com/selection-sort-in-java
 *
 */


package module2_4;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class benchmarks {
    private static final int LIST_SIZE = 10000;
    private static int[] positiveOnly;
    private static int[] positiveAndNegative;
    private static int[] sorted;
    private static int[] reversedSorted;

    private static DecimalFormat df = new DecimalFormat("0.0000");
    private static Stopwatch stopwatch;


    /*
    Setup the arrays
    Run Sorting methods, and using the Stopwatch class, log the runtime of each method
     */
    public static void main(String[] args) {
        //Setup arrays for selection sort
        setupArrays(LIST_SIZE);

        stopwatch = new Stopwatch();
        SelectionSort.selectionSort(positiveOnly);
        System.out.println("positiveOnly sorted with selectionSort in " + df.format(stopwatch.elapsedTime()) + " seconds");

        stopwatch = new Stopwatch();
        SelectionSort.selectionSort(positiveAndNegative);
        System.out.println("positiveAndNegative sorted with selectionSort in " + df.format(stopwatch.elapsedTime()) + " seconds");

        stopwatch = new Stopwatch();
        SelectionSort.selectionSort(sorted);
        System.out.println("sorted sorted with selectionSort in " + df.format(stopwatch.elapsedTime()) + " seconds");

        stopwatch = new Stopwatch();
        SelectionSort.selectionSort(reversedSorted);
        System.out.println("reversedSorted sorted with selectionSort in " + df.format(stopwatch.elapsedTime()) + " seconds");

//        //Scramble the arrays again for the quicksort testing
//        setupArrays(LIST_SIZE);
//
//        stopwatch = new Stopwatch();
//        QuickSort.quickSort(positiveOnly, 0, LIST_SIZE - 1);
//        System.out.println("positiveOnly sorted with quickSort in " + df.format(stopwatch.elapsedTime()) + " seconds");
//
//        stopwatch = new Stopwatch();
//        QuickSort.quickSort(positiveAndNegative, 0, LIST_SIZE - 1);
//        System.out.println("positiveAndNegative sorted with quickSort in " + df.format(stopwatch.elapsedTime()) + " seconds");
//
//        stopwatch = new Stopwatch();
//        QuickSort.quickSort(sorted, 0, LIST_SIZE - 1);
//        System.out.println("sorted sorted with quickSort in " + df.format(stopwatch.elapsedTime()) + " seconds");
//
//        stopwatch = new Stopwatch();
//        QuickSort.quickSort(reversedSorted, 0, LIST_SIZE - 1);
//        System.out.println("reversedSorted sorted with quickSort in " + df.format(stopwatch.elapsedTime()) + " seconds");

    }

    /*
    Instantiate the four arrays we'll test with, with size LIST_SIZE
     */
    public static void setupArrays(int size) {
        //positiveOnly Setup
        positiveOnly = new int[size];
        for(int i = 0; i < size - 1; i++) {
            positiveOnly[i] = randomNumber(0, 2000);
        }

        //positiveAndNegative setup
        positiveAndNegative = new int[size];
        for(int i = 0; i < size - 1; i++) {
            positiveAndNegative[i] = randomNumber(-2000,2000);
        }

        //sorted setup
        sorted = new int[size];
        for(int i = 0; i < size - 1; i++) {
            sorted[i] = randomNumber(-2000, 2000);
        }
        Arrays.sort(sorted);

        //reversedSorted setup
        reversedSorted = sorted;
        Collections.reverse(Arrays.asList(reversedSorted));
    }

    public static int randomNumber(int min, int max) {
        Random random  = new Random();
        return random.ints(min, max).findFirst().getAsInt();
    }

}

class SelectionSort {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;//searching for lowest index
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }
}

class QuickSort {
    // A function to swap two elements
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */
    static int partition(int[] arr, int low, int high)
    {

        // pivot
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /* The main function that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */
    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}