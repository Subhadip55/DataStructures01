package com.sj.adt;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class SinglyLinkedList<T> {


    public static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    public SinglyLinkedList() {
        this.head = null;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    // add element to the last
    public void append(T data) {
        // case 1: list is empty
        if(this.head == null) {
            this.head = new Node<T>(data);
            this.head.next = null;
        }

        // case 2: list is not empty
        else {
            Node new_node = new Node<T>(data);
            Node<T> temp = this.head;
            while(temp.next != null) {  // traversing to the last node
                temp = temp.next;
            }
            temp.next = new_node;
            new_node.next = null;
        }
    }

    // insert into an index position
    public void insert(int index, T data) {
        int count = 0;
        Node<T> new_node = new Node<T>(data);

        if(this.head == null) {
            System.out.println("As list is empty, it will be added in the head" +
                    "\nSo, index will not matter here");
            this.head = new Node<T>(data);
            this.head.next = null;
        }
        else {
            Node<T> temp = this.head;
            Node<T> previous_node = null;

            if(index - count == 0){ // if index is zero
                new_node.next = head;
                head = new_node;
            }
            else if(index - count > 0) {
                while(temp.next != null && (index-count) > 0) { // find the exact node at index and its prev node
                    previous_node = temp;
                    temp = temp.next;
                    count++;
                }
                if(temp.next != null) {
                    new_node.next = temp;
                    previous_node.next = new_node;
                }
                else {
                    // we reached at the last of the list
                    // temp is the last element
                    // now, there would be 2 possibilities
                    //1. index value is greater than the length of list
                    if (index > count) {
                        temp.next = new_node;
                        new_node.next = null;
                    }
                    //2. index value is the length -1
                    else {
                        previous_node.next = new_node;
                        new_node.next = temp;
                    }
                }
            }
           else {
                System.out.println("Negative index is not allowed.");
            }

        }
    }

    // find
    public int find(T data) { // find the data returns index
        int count = 0;
        Node<T> temp = this.head;
        while(temp.next != null) {
            if (temp.data == data) {
                return count;
            }
            temp = temp.next;
            count++;
        }
        if(temp.data == data)
            return count;
        else
            return -1;
    }

    public T findByIndex(int index) {   // find data by index, return data
        int count = 0;
        Node<T> temp = this.head;
        for(int i = 0 ; i < index && temp.next != null; i++) {
            temp = temp.next;
        }
        T obj = temp.data;
        return obj;
    }

    // remove
    public boolean remove(T data) {    // remove the data

        Node<T> temp = this.head;
        Node<T> previous = null;
        while(temp.next != null) {
            if (temp.data == data) {
                // checking that if the matched data is in head position or not
                if(temp == head) {
                    head = temp.next;
                }
                else {
                    previous.next = temp.next;
                }
                return true;
            }
            previous = temp;
            temp = temp.next;
        }
        return false;
    }

    // remove by index
    public T removeByIndex(int index) {
        if (index < 0) {
            return null;
        }
        Node<T> temp = this.head;
        Node<T> previous = null;
        int count = 0;
        while(temp.next != null && (index-count) > 0) {
            previous = temp;
            temp = temp.next;
            count++;
        }
        previous.next = temp.next;
        return temp.data;
    }

    // update
    public boolean update(T old_data, T new_data) {
        Node<T> temp = this.head;
        while(temp.next != null) {
            if (temp.data == old_data) {
                temp.data = new_data;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // print list
    public void printList() {
        if (this.head == null) {
            System.out.println("List is empty.");
        }
        else {
            Node temp = this.head;
            System.out.print("["+temp.data);

            while(temp.next != null) {
                temp = temp.next;
                System.out.print(", "+ temp.data);
            }
            System.out.print("]");
            System.out.println();
        }
    }

}

// in main method
//SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
//        list.append(23);
//                list.append(12);
//                list.append(42);
//                list.append(8);
//                System.out.print("List = ");
//                list.printList();
//
//                list.insert(2, 53);
//                System.out.print("List = ");
//                list.printList();
//
//                int index = list.find(8);
//                System.out.println("Index = "+index);
//
//                int data = list.findByIndex(2);
//                System.out.println("Find by index 2: "+data);
//
//                list.remove(-3);    // -ve not allowed, so no removal
//                list.removeByIndex(3);
//                System.out.print("After deletion, List = ");
//                list.printList();
//
//                list.update(12, -3);
//                System.out.print("After update, List = ");
//                list.printList();
