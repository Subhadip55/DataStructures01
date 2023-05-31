package com.sj.arrayoperations;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Sorting {
    /*
    * 1. Bubble sort
    *       Best case: O(n), Average case: O(n^2), Worst case: O(n^2)
    * 2. Insertion sort
    *       Best case: O(n), Average case: O(n^2), Worst case: O(n^2)
    * 3. Merge Sort
    *       Best case: O(nlog n), Average case: O(nlog n), Worst case: O(nlog n)
    * 4. Quick sort
    *       Best case: O(nlog n), Average case: O(nlog n), Worst case: O(n^2)
    * 5. Heap sort
    * */



    // Bubble sort
    public int[] bubbleSort(int[] input_array) {
        long no_of_swaps = 0;
        long no_of_iteration = 0;
        long start_time = System.currentTimeMillis();

        boolean sorted = false, swapped = false;

        while(!sorted) {
//            searching will stop when there is no swap operation

            for (int i = 1; i < input_array.length; i++) {
                no_of_iteration++;
//               check every element with its consecutive element when it is greater or lesser
                if (input_array[i-1] > input_array[i]) {
                    // do swap operation
                    int temp = input_array[i];
                    input_array[i] = input_array[i-1];
                    input_array[i-1] = temp;

                    swapped = true; // when swapped happen
                    no_of_swaps++;
                }
            }
            if (swapped) {  // swapped happened, then we need to scan again
                swapped = false;
                continue;
            }

            if(swapped == false)    // when there is no swap even after full scanning
                sorted = true;  // then we need to stop looping, means array is sorted
        }
        long end_time = System. currentTimeMillis();
        long execution_time = (end_time - start_time);
        System.out.println("Bubble sort\n----------------\n" +
                "Iteration count : " + no_of_iteration +
                "\nSwap count : " + no_of_swaps +
                "\nExecution time : " + execution_time +" ms\n");  // Measuring how much time spends in bubble sort
        return input_array;
    }


    // insertion sort : picks element and puts / inserts in its appropriate position
    public int[] insertionSort(int[] input_array) {
        long no_of_swaps = 0;
        long no_of_iteration = 0;
        long start_time = System.currentTimeMillis();

        for(int i = 1; i < input_array.length; i++) {
            if(input_array[i] < input_array[i-1]) {
                for(int p = i; p > 0; p--) {    // this for loop will put the element to its right position
                    no_of_iteration++;
                    if(input_array[p] < input_array[p-1]) {
                        int temp = input_array[p];
                        input_array[p] = input_array[p-1];
                        input_array[p-1] = temp;
                        no_of_swaps++;
                    }
                    else {
                        break;
                    }
                }
            }
        }
        long end_time = System. currentTimeMillis();
        long execution_time = (end_time - start_time);
        System.out.println("Insertion sort\n----------------\n" +
                "Iteration count : " + no_of_iteration +
                "\nSwap count : " + no_of_swaps +
                "\nExecution time : " + execution_time +" ms");  // Measuring how much time
        return input_array;
    }
    /*
    * Algorithm:
    * 1. start from index 1
    * 2. check whether previous value is greater than the current index(i.e. 1)
    * 3. If it is true, then make another loop where loop counter will start from the current index and it will move backwards
    * 4. This loop will repeat until the value finds its proper position
    * 5. Inside the loop, once again check whether the prev value is greater than the current one, then swap
    * 6. Else, break from that loop
    * 7. Outer loop will execute until the array is sorted.
    * */

    public int[] mergeSort(int[] input_array) {
        long start = System.currentTimeMillis();

        int[] output_array = divide(input_array);

        long end = System.currentTimeMillis();
        long execution_time = end - start;

        System.out.println("\nMerge sort\n----------------\n" +
                "Execution time : " + execution_time + " ms");

        return output_array;
    }

    public int[] divide(int[] array) {
        if(array.length <= 1) { // return the array when there is single element
            return  array;
        }
        int mid = array.length / 2;
        int[] left_array = Arrays.copyOfRange(array, 0, mid);
        int[] right_array = Arrays.copyOfRange(array, mid, array.length);

        divide(left_array);
        divide(right_array);

        return conquer(array, left_array, right_array);
    }

    public int[] conquer(int[] array, int[] left, int[] right) {

        int i=0, j = 0, k = 0;

        while(i < left.length && j < right.length) {
            if(left[i] < right[j]) {
                array[k++] = left[i++];
            }
            else {
                array[k++] = right[j++];
            }
        }
        while(i < left.length) {
            array[k++] = left[i++];
        }
        while(j < right.length) {
            array[k++] = right[j++];
        }
        return array;
    }

    public void callQuickSort(int[] array) {
        long start = System.currentTimeMillis();

        quickSort(array, 0, array.length - 1);      // call the quick sort method
        long end = System.currentTimeMillis();
        long execution_time = end - start;
        System.out.println("\nQuick Sort\nExecution time : " + execution_time + " ms");
    }
    public void swap(int[] array, int i, int j) {
        if(i < 0 || j < 0) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /*
        this function will return the index of pivot
        starting of the function pivot wil be the right most element of the array
        this function will place all the smaller elements to left of the pivot
        and all the greater elements to the right of the pivot.
     */
    public int partition(int[] array, int low, int high) {
        int pivot = array[high];    // value of the last element
        int i = low - 1;
        for(int j = low; j < high; j++) {
            if(array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i+1;     // this is the index of the pivot element
    }

    public void quickSort(int array[], int low, int high) {

        if (low < high) {
            int pi = partition(array, low, high);   // pi = partitioning index

            quickSort(array, low, pi -1);
            quickSort(array, pi + 1, high);
        }
    }
}