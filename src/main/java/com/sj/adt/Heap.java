package com.sj.adt;


import com.sj.Exceptions.UserException;

import java.util.Arrays;

public class Heap<T extends Comparable<T>> {
//    2 types of heap
//    1. max heap
//    2. min heap
//    represented as array

    public static final int default_capacity = 7;   // setting the default capacity
    int capacity = 0;               // length of the array
    T[] heap_array = null;          // heap represented by array
    int count = 0;                 // count determines the no. of elements in heap
                                    // at initial level, no element is in heap, so count = -1

    boolean isMaxHeap = false;
// we will assume by default, heap will min heap, if user does not
//    specify

    public Heap() {
        capacity = default_capacity;
        heap_array =  (T[]) new Comparable[capacity];
//        heap_array = new T[capacity];
//        We assume that this tree is min heap as user does not specify
    }

    public Heap(boolean isMaxHeap) {
        capacity = default_capacity;
        this.isMaxHeap = isMaxHeap;     // user has specified here
        heap_array =  (T[]) new Comparable[capacity];
    }

    public Heap(int capacity) {
        this.capacity = capacity;
        heap_array =  (T[]) new Object[capacity];
//        We assume that this tree is min heap as user does not specify

    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public T[] getHeap_array() {
        return heap_array;
    }

    public void setHeap_array(T[] heap_array) {
        this.heap_array = heap_array;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isMaxHeap() {
        return isMaxHeap;
    }

    public void setMaxHeap(boolean maxHeap) {
        isMaxHeap = maxHeap;
    }

    /*
// We don't need
//    check complete heap
    public boolean isCompletetree(T[] array) {
//    so the logic is we need to check every level of the tree.
//        if the left child is absent but the right is present. then the tree is incomplete.
//         return flag as false
//        boolean flag = true;
//        int i = 0;
//
//        while (array[i] != null) {
//            if (array[i++] != null) {
//
//            }
//        }
//        return flag;
    }


//    heap needs to satisfy the heap property.
//    we have to check whether it is complete heap or not
    public boolean validate() {
        return isCompletetree(heap_array);
    }
*/

//    Swap
    public void swap(int left, int right) {
        T temp = heap_array[left];
        heap_array[left] = heap_array[right];
        heap_array[right] = temp;
    }

//    get parent index
    public int parent(int index) {
        return (index - 1) / 2;
    }

//    get left child's index
    public int left(int index) {
        return (index * 2) + 1;
    }

//    get right child's index
    public int right(int index) {
        return (index * 2) + 2;
    }

//    compare method
//     checking whether left is greater than right or not
    public boolean compare(int left, int right) {
//        return ((Integer)heap_array[left] > (Integer) heap_array[right]);
        return heap_array[left].compareTo(heap_array[right]) > 0;
    }

//    1. push / add
    public synchronized void push(T value) {
        try {
            growIfNeeded();

    //        add new value to the end of the heap array
            heap_array[count] = value;

    //        now, check whether heap property is satisfied or not

              int index = count;
    //          when index is zero, we heed to stop
              while(index > 0 && isMaxHeap == compare(index, parent(index))) {
                    swap(parent(index), index);
                    index = parent(index);
              }
              count++;
        }
        catch(ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public void growIfNeeded() {
        if (count == capacity) {
//             that means the heap array is full
//            needs to increase the size of heap array
//             that means grow is needed.

            capacity = capacity * 2 + 1;
            T[] new_array = (T[]) new Comparable[capacity];

//            copy the heap_array data to new_array

//            Arrays.copyOfRange will not work
//            new_array = Arrays.copyOfRange(heap_array, 0, count);
            for (int i = 0; i < heap_array.length; i++) {
                new_array[i] = heap_array[i];
            }

//            re-assigning the array / updating heap_array
            heap_array = new_array;
        }
//        else grow is not needed
    }


//    2. Top / min or max element i.e. 0th index
    public T top() {
        if (count > 0)
            return heap_array[0];
        try {
            throw new UserException("No data is present in heap.");
        } catch (UserException e) {
            e.printStackTrace();
        }
        finally {
            return null;
        }
    }
//    3. pop / remove the root i.e. 0th index
    public synchronized void pop() {
        if (count == 0) {
//            when there is no data
            try {
                throw new UserException("Heap is empty. So pop can't be executed.");
            }
            catch (UserException e) {
                e.printStackTrace();
            }
            finally {
                return;
            }
        }
        else if (count == 1) {
//             when there is only root
            count = 0;

//            by removing root there will be no data
            heap_array[0] = null;   // removing root

//            System.out.println("Pop successful");
            return;
        }

//        when there are more than ohe data present ih the heap.
//        replace 0th index with the last data
        heap_array[0] = heap_array[count-1];
        heap_array[count - 1] = null;   // so the last data will be null

        count--;

//        now put 0 index to its appropriate position
        pushDownIfNeeded(0);
    }

    private void pushDownIfNeeded(int parent) {
        int lChild = left(parent);
        int rChild = right(parent);

        // scenario 1: no child // leaf node
        if (lChild >= count) {
//            why this condition
//            if any index does not have left child
//            then left child's index must greater than count
//            If left child does not exist then right also does not exist
//            as it is a complete tree
            return;
        }

        // scenario 2: only left
        if (rChild >= count) {  // this condition tells that there is no right child
//            the parent is less than it's left child (in case of max heap)
//            the parent is more than it's left child (in case of min heap)
            if (isMaxHeap == compare(lChild, parent)) {
                swap(parent, lChild);
                pushDownIfNeeded((lChild));
                return;
            }
        }

//        scenario 3: two children
        if (isMaxHeap == compare(lChild, rChild)) {
//            if left child is less than right child in case of min heap
//            if left child is greater than right child in case of max heap
            if (isMaxHeap == compare(lChild, parent)) {
//                if left child is less than parent in case of min heap
//                if left child is greater than parent in case of maz heap
                swap(parent, lChild);   // swap left and parent
                pushDownIfNeeded(lChild);
                return;
            }
        }
        else {
//            if left child is greater than right child in case of min heap
//            if left child is less than right child in case of max heap
            if (isMaxHeap == compare(rChild, parent)) {
//                if right child is less than parent in case of min heap
//                if right child is greater than parent in case of maz heap
                swap(parent, rChild);   // swap right with parent
                pushDownIfNeeded(rChild);
                return;
            }
        }
    }

//    display heap in array format
    public void displayHeap() {
        System.out.println(Arrays.toString(heap_array));
    }
}
