package com.sj.adt;

public class StackADT<T> {
    DoublyLinkedList<T> dl;

    public StackADT() {
        dl = new DoublyLinkedList<>();
    }

    public DoublyLinkedList<T> getDl() {
        return dl;
    }

    public T getTop() { // top ==> tail
        return dl.getTail().data;
    }

    public T getBottom() {  // bottom ==> head
        return dl.getHead().data;
    }

    // push
    public boolean pushData(T data) {
        if (data == null) {
            return false;
        }
        dl.append(data);
        return true;
    }
    // pop
    public T popData() {
        if(dl.getHead() == null) {
            return null;
        }
        else {
            T data = dl.getTail().data;
            if (dl.deleteByData(data)) {
                return data;
            }
        }
        return null;
    }
    // peek
    public T peekData() {
        if(dl.getHead() == null) {
            return null;
        }
        else {
            T data = dl.getTail().data;
            return data;
        }
    }

    // print stack
    public void printStack() {
        dl.printList();
    }
}

/*
* main method
        StackADT<Integer> stack = new StackADT<>();
        stack.pushData(23);
        stack.pushData(12);
        stack.pushData(98);
        System.out.print("After push\t");
        stack.printStack();

        System.out.println("Top = "+ stack.getTop() + "\tBottom = "+ stack.getBottom());

        System.out.print("Pop\t"+ stack.popData() + "\t");
        stack.printStack();

        System.out.print("Peek\t"+ stack.peekData() + "\t");
        stack.printStack();
        System.out.println("Top = "+ stack.getTop() + "\tBottom = "+ stack.getBottom());

        System.out.print("Pop\t"+ stack.popData() + "\t");
        stack.printStack();

        System.out.print("Peek\t"+ stack.peekData() + "\t");
        stack.printStack();
        System.out.println("Top = "+ stack.getTop() + "\tBottom = "+ stack.getBottom());

        System.out.print("Pop\t"+ stack.popData() + "\t");
        stack.printStack();

*
* */
