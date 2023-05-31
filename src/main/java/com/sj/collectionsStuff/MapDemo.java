package com.sj.collectionsStuff;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        Map<Integer, Student> m1 = new HashMap<Integer, Student>();
        m1.put(1, new Student(1001, "Ram Sharma", 23));
        m1.put(2, new Student(1002, "Mukti Mohon", 21));
        m1.put(3, new Student(1003, "Vikash Khanna", 34));
        m1.put(4, new Student(1001, "Ram Sharma", 23));

        Set convertMaptoSet = m1.entrySet();

        Iterator itr = convertMaptoSet.iterator();

        while(itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println(m1.size());
    }
}
