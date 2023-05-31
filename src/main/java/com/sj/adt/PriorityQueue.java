package com.sj.adt;

public class PriorityQueue<T extends Comparable<T>> {
    Heap<T> heap;

    public PriorityQueue() {
        heap = new Heap<>(true);
    }

    // Enqueue
    public void enqueue(T data) {
        heap.push(data);
    }

    // Dequeue
    public T dequeue() {
        T topValue = heap.top();
        heap.pop();
        return topValue;
    }

    // get the size of the priority queue
    public int size() {
        return heap.getCount();
    }

//    display queue
    public void show() {
        heap.displayHeap();
    }
}
