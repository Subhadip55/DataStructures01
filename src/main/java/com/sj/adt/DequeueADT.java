package com.sj.adt;

// Doubly Ended Queue
public class DequeueADT<T> {
    DoublyLinkedList<T> dl;

    public DequeueADT() {
        dl = new DoublyLinkedList<>();
    }

    public T getHead() {
        return dl.getHead().data;
    }

    public T getTail() {
        return dl.getTail().data;
    }

    // enqueue head
    public boolean enqueueHead(T data) {
        if (data == null)
            return false;
        else {
            dl.insert(0, data);
            return true;
        }
    }
    // enqueue tail
    public boolean enqueueTail(T data) {
        if (data == null)
            return false;
        else {
            dl.append(data);
            return true;
        }
    }
    // dequeue head
    public T dequeueHead() {
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
    // dequeue tail
    public T dequeueTail() {
        if(dl.getTail() == null)
            return null;
        else {  // removing from tail
            T data = dl.getTail().data;
            if(dl.deleteByData(data))
                return data;
            else
                return null;
        }
    }
    // peek head
    public T peekHead() {
        if(dl.getHead() == null)
            return null;
        else {
            T data = dl.getHead().data;
            return data;
        }
    }
    // peek tail
    public T peekTail() {
        if(dl.getTail() == null)
            return null;
        else {
            T data = dl.getTail().data;
            return data;
        }
    }
    // print
    public void printDequeue() {
        dl.printList();
    }
}

/*
* main
        DequeueADT<Integer> dequeue = new DequeueADT<>();
        dequeue.enqueueHead(23);
        dequeue.enqueueHead(12);
        dequeue.enqueueTail(98);
        dequeue.enqueueTail(45);
        dequeue.enqueueHead(31);
        System.out.print("After enqueue\t");
        dequeue.printDequeue();                 // 31, 12, 23, 98, 45

        System.out.println("Head = "+ dequeue.getHead() + "\tTail = "+ dequeue.getTail());
        System.out.print("Peek head = "+ dequeue.peekHead() + "\tPeek tail = " + dequeue.peekTail()+ "\t");
        dequeue.printDequeue();

        System.out.print("Dequeue head = "+ dequeue.dequeueHead() + "\t");
        dequeue.printDequeue();

        System.out.print("Dequeue tail = "+ dequeue.dequeueTail() + "\t");
        dequeue.printDequeue();

        System.out.println("Head = "+ dequeue.getHead() + "\tTail = "+ dequeue.getTail());
        System.out.print("Peek head = "+ dequeue.peekHead() + "\tPeek tail = " + dequeue.peekTail()+ "\t");
        dequeue.printDequeue();

        System.out.print("Dequeue tail = "+ dequeue.dequeueTail() + "\t");
        dequeue.printDequeue();

        System.out.print("Peek head = "+ dequeue.peekHead() + "\tPeek tail = " + dequeue.peekTail()+ "\t");
        dequeue.printDequeue();
        System.out.println("Head = "+ dequeue.getHead() + "\tTail = "+ dequeue.getTail());

        System.out.print("Dequeue head = \t"+ dequeue.dequeueHead() + "\t");
        dequeue.printDequeue();

        System.out.print("Dequeue head = \t"+ dequeue.dequeueHead() + "\t");
        dequeue.printDequeue();

        System.out.print("Dequeue head = \t"+ dequeue.dequeueHead() + "\t");
        dequeue.printDequeue();
* */
