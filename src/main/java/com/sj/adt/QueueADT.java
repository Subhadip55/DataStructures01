package com.sj.adt;

public class QueueADT<T> {
    DoublyLinkedList<T> dl;
    public QueueADT() {
        dl = new DoublyLinkedList<>();
    }

    public T getHead() {
        return dl.getHead().data;
    }
    public T getTail() {
        return dl.getTail().data;
    }

    // enqueue
    public boolean enqueueData(T data) {
        if (data == null)
            return false;
        else
            dl.append(data);
            return true;
    }
    // dequeue
    public T dequeueData() {
        if(dl.getHead() == null)
            return null;
        else {
            T data = dl.getHead().data; // removing from head
            if(dl.deleteByData(data))
                return data;
            else
                return null;
        }
    }

    // peek
    public T peekData() {
        if(dl.getHead() == null)
            return null;
        else {
            T data = dl.getHead().data;
            return data;
        }
    }

    // print
    public void printQueue() {
        dl.printList();
    }
}

/*
* main method
        QueueADT<Integer> queue = new QueueADT<>();
        queue.enqueueData(23);
        queue.enqueueData(12);
        queue.enqueueData(98);
        System.out.print("After enqueue\t");
        queue.printQueue();

        System.out.println("Head = "+ queue.getHead() + "\tTail = "+ queue.getTail());

        System.out.print("Dequeue\t"+ queue.dequeueData() + "\t");
        queue.printQueue();

        System.out.print("Peek\t"+ queue.peekData() + "\t");
        queue.printQueue();
        System.out.println("Head = "+ queue.getHead() + "\tTail = "+ queue.getTail());

        System.out.print("Dequeue\t"+ queue.dequeueData() + "\t");
        queue.printQueue();

        System.out.print("Peek\t"+ queue.peekData() + "\t");
        queue.printQueue();
        System.out.println("Head = "+ queue.getHead() + "\tTail = "+ queue.getTail());

        System.out.print("Dequeue\t"+ queue.dequeueData() + "\t");
        queue.printQueue();
* */