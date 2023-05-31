package com.sj.collectionsStuff;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(12);
        list.add(10);
        list.add(2);
        list.add(23);
        list.add(2,4);
        System.out.println(list);

    }
}
