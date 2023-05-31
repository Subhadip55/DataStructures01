package com.sj.adt;

public class DoublyLinkedList<T> {
    public static class Node<T> {
        T data;
        Node<T> previous;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
    Node<T> head = null;
    Node<T> tail = null;

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    // add
    public void append(T data) {
        Node<T> new_node = new Node<T>(data);
        // 1. list is empty
        if(head == null) {
            head = new_node;
            head.previous = null;
            head.next = null;
            tail = head;
        }
        // 2. list is not empty
        else {
            Node<T> temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = new_node;
            new_node.previous = temp;
            new_node.next = null;
            tail = new_node;
        }
    }

    public void insert(int index, T data) {
        int count = 0;
        Node<T> new_node = new Node<T>(data);

        if(head == null) {
            System.out.println("As list is empty, it will be added in the head" +
                    "\nSo, index will not matter here");
            head = new Node<T>(data);
            head.next = null;
        }
        else {
            Node<T> temp = head;

            if(index - count == 0){ // if input index is zero
                new_node.next = head;
                new_node.previous = null;
                head = new_node;
            }
            else if(index - count > 0) {
                while(temp.next != null && (index-count) > 0) { // find the exact node at index and its prev node
                    temp = temp.next;
                    count++;
                }
                if(temp.next != null) { // in between element
                    temp.previous.next = new_node;
                    new_node.previous = temp.previous;
                    new_node.next = temp;
                    temp.previous = new_node;

                }
                else {
                    // we reached at the last of the list
                    // temp is the last element
                    // now, there would be 2 possibilities
                    //1. index value is greater than the length of list
                    if(index > count) {
                        temp.next = new_node;
                        new_node.next = null;
                        new_node.previous = temp;
                        tail = new_node;
                    }
                    //2. index value is the length -1
                    else {
                        temp.previous.next = new_node;
                        new_node.previous = temp.previous;
                        new_node.next = temp;
                        temp.previous = new_node;
                        tail = temp;
                    }
                }
            }
            else {
                System.out.println("Negative index is not allowed.");
            }

        }
    }

    // find
    public int find(T data) {
        int count = 0;
        Node<T> temp = head;
        while(temp.next != null) {
            if(temp.data == data) {
                return count;
            }
            temp = temp.next;
            count++;
        }
        if(temp.data == data) {
            return count;
        }
        else {
            return -1;
        }
    }
    public T findByIndex(int index) {
        if(index < 0) {
            return null;
        }
        int count = 0;
        Node<T> temp = head;
//        while(temp.next != null) {    // alternate process
//            if(index - count == 0) {
//                return temp.data;
//            }
//            temp = temp.next;
//            count++;
//        }
//        if(index - count == 0) {
//            return temp.data;
//        }
//        return null;
        for(int i = 0 ; i < index && temp.next != null; i++) {
            temp = temp.next;
        }
        if(index > count && temp.next == null)
            return null;
        T obj = temp.data;
        return obj;
    }
    // update
    public boolean update(T old_data, T new_data) {
        Node<T> temp = head;
        while(temp.next != null) {
            if(temp.data == old_data) {
                temp.data = new_data;
                return true;
            }
            temp = temp.next;
        }
        if(temp.data == old_data) {
            temp.data = new_data;
            return true;
        }
        else{
            return false;
        }
    }
    // delete
    public boolean deleteByData(T data) {
        Node<T> temp = head;
        if(head.data == data) {  // for head node
            head = temp.next;
            if (head != null)
                head.previous = null;
            return true;
        }
        while(temp.next != null) {
            if(temp.data == data) {
               temp.previous.next = temp.next;
               temp.next.previous = temp.previous;
                return true;
            }
            temp = temp.next;
        }
        if(temp.data == data) {
            tail = temp.previous;
            tail.next = null;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean deleteByIndex(int index) {
        int count = 0;
        Node<T> temp = head;
        if(index == count++) {  // for head node
            head = temp.next;
            head.previous = null;
            return true;
        }
        temp = temp.next;
        while(temp.next != null) {
            if(index == count++) {
                temp.previous.next = temp.next;
                temp.next.previous = temp.previous;
                return true;
            }
            temp = temp.next;
        }
        if(index == count++) {  //for last node
            tail = temp.previous;
            tail.next = null;
            return true;
        }
        return false;
    }
    // print
    public void printList() {
        if(head == null) {
            System.out.println("list is empty");
        }
        else if(head.next == null) {
            // that means only one element is in the list
            System.out.println("["+ head.data +"]");
        }
        else  {
            Node<T> temp = head;
            System.out.print("["+ temp.data);
            while(temp.next != null) {
                temp = temp.next;
                System.out.print(", "+ temp.data);
            }
            System.out.print("]");
            System.out.println();
        }

    }
}
// main
    /*
DoublyLinkedList<Integer> dl = new DoublyLinkedList<>();
        dl.append(2);
                dl.append(1);
                dl.append(4);
                dl.append(3);
                System.out.print("list = ");
                dl.printList();

                dl.insert(2, 0);
                System.out.print("list = ");
                dl.printList();

                System.out.println("Index = " + dl.find(3));
                System.out.println("Data = " + dl.findByIndex(2));


                if (dl.update(0, 5))
                System.out.println("Value updated");
                dl.printList();

                dl.deleteByData(3);
                dl.printList();

                dl.deleteByIndex(3);
                dl.printList();
*/