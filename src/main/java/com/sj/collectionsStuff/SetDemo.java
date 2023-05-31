package com.sj.collectionsStuff;

import java.util.*;

public class SetDemo {
    public static void main(String[] args) {

        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(12);
        hashSet.add(-1);
        hashSet.add(7);
        hashSet.add(2);
        hashSet.add(-44);
        hashSet.add(-1);    // duplicate

        System.out.println("Set : " + hashSet+
                            "\nSize : " + hashSet.size() +
                            "\nEmpty? : " + hashSet.isEmpty() +
                            "\n7 is present ? : " + hashSet.contains(7));

//        printing via iterable
        Iterator itr = hashSet.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

//    add element
        hashSet.add(13);
        System.out.println("Set : " + hashSet);
//        remove element
        hashSet.remove(-1);
        System.out.println("Set : "+ hashSet);
//        contains
        System.out.println("-1 is present? : " + hashSet.contains(-1));
//        count
        System.out.println("Count : " + hashSet.size());


        Set<Integer> hashSet2 = new HashSet<>();
        hashSet2.addAll(Arrays.asList(2, -1, 7, -44, 14));
        System.out.println("Set 1 : " + hashSet);
        System.out.println("Set 2 : " + hashSet2);
        //    union
        hashSet.addAll(hashSet2);
        System.out.println("Set 1 : " + hashSet);
        System.out.println("Set 2 : " + hashSet2);
        //    intersection

        //    difference
        //    Symmetric Difference

        //

    }

}
