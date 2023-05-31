package com.sj.arrayoperations;

import java.util.Arrays;

public class BinarySearching<T> {
    public int binarySearch(T[] array, int low, int high, T key) {
        // assuming the array is already sorted in ascending order
        if(high >= low) {
            int mid = low + (high - low) / 2;
            int x = (Integer) array[mid];
            if((Integer)array[mid] == (Integer) key) {
                return mid;
            }
            else if((Integer)key < (Integer)array[mid]) {
                return binarySearch(array, low, mid - 1, key);
            }
            else {
                return binarySearch(array, mid + 1, high, key);
            }
        }
        return -1;
    }
}

/*
main method
        BinarySearching<Integer> bs = new BinarySearching<>();
        Integer[] array = {4, 9, 12, 25, 42, 85, 91};
        int index = bs.binarySearch(array, 0, array.length, 12);
        System.out.println("Index =  "+ index);
* */
