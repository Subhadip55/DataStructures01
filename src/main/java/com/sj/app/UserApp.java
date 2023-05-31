package com.sj.app;


import com.sj.adt.PriorityQueue;
import com.sj.adt.TaskScheduler;

public class UserApp {
    public static void main(String[] args) {

        TaskScheduler task;
        PriorityQueue<TaskScheduler> queue = new PriorityQueue<>();

        for (int i = 1; i < 101; i++) {
            task = new TaskScheduler(i, i % 9);
            queue.enqueue(task);
        }

//        System.out.println("Queue size " + queue.size());
//        queue.show();

        int i = 0;
        int no_of_iteration = queue.size();
        while (i < no_of_iteration) {
            queue.dequeue().execute();
            i++;
        }

    }

}
