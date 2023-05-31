package com.sj.adt;


// also known as Job scheduler

public class TaskScheduler implements Comparable<TaskScheduler> {
    private int taskId;
    private int priority;

    public TaskScheduler(int taskId, int priority) {
        this.taskId = taskId;
        this.priority = priority;
    }

    public void execute() {
        System.out.println("Executing task (task Id " + taskId + ") with priority " + priority);
    }

    @Override
    public int compareTo(TaskScheduler o) {
        if (o == null) {
            return 1;   //  any positive value
        }

        return this.priority - o.priority;
    }

    @Override
    public String toString() {
        return "TaskScheduler{" +
                "taskId=" + taskId +
                ", priority=" + priority +
                '}';
    }
}
