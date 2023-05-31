package com.sj.collectionsStuff;

import java.util.*;

public class ArraylistDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1001, "Ram Sharma", 23));
        list.add(new Student(1002, "Mukti Mohon", 21));
        list.add(new Student(1003, "Vikash Khanna", 34));
        list.add(new Student(1001, "Ram Sharma", 23));

        Collections.sort(list, new DuplicateChecker()); // in case of Comparator<>
//        Collections.sort(list);   // in case of Comparable<>
        System.out.println(list);
        System.out.println();

        Set<Student> studentSet = new HashSet<>();
        studentSet.add(new Student(1001, "Ram Sharma", 23));
        studentSet.add(new Student(1002, "Mukti Mohon", 21));
        studentSet.add(new Student(1003, "Vikash Khanna", 34));
        studentSet.add(new Student(1001, "Ram Sharma", 23));


        Iterator itr = studentSet.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }


    }
}
