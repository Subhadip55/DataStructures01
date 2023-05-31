package com.sj.collectionsStuff;

import java.util.Comparator;

public class DuplicateChecker implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getRollNo() - o2.getRollNo(); // ascending order
        // return o2.getROllNo() - o1.getRollNo() // descending order
        /*
        * ascending order

        if(o1.getRollNo() - o2.getRollNo() > 0)
            return 1;
        else if(o1.getRollNo() - o2.getRollNo() < 0)
            return -1;
        else
            return 0;

         */
    }
}

