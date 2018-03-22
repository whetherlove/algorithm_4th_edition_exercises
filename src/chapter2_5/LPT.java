package chapter2_5;

import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;


/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_5
 * @Description:
 * @date 17/03/2018 1:41 PM
 */
public class LPT {

    private int taskSize;
    private MaxPQ<Task> tasks = new MaxPQ<>();
    private ArrayList<Task> completedTasks = new ArrayList<>();
    private Queue<Processor> waitingProcessors = new Queue<>();
    private ArrayList<Processor> workingProcessors = new ArrayList<>();
    private ArrayList<Processor> transitionProcessors = new ArrayList<>();

    private static class Task implements Comparable{
        private String name;
        private long duration;
        private long startTime;

        Task(String name, long duration) {
            this.name = name;
            this.duration = duration;
        }

        @Override
        public int compareTo(Object o) {
            return (int) (duration - ((Task)o).duration);
        }

        @Override
        public String toString() {
            return '{' + name + ',' + duration + '}';
        }
    }

    private class Processor {
        private int No; //processor No.
        private Task task;

        Processor(int no) {
            No = no;
        }
    }

    private void initProcessors(int M){
        for (int i = 1; i <= M; i++) {
            waitingProcessors.enqueue(new Processor(i));
        }
    }

    private void initTasks(ArrayList<Task> taskList){
        for(Task t : taskList)
            tasks.insert(t);
        taskSize = taskList.size();
    }

    private long run() {
        long currentTime = 0;
        while (completedTasks.size() != taskSize){
            //check all working processors
            //if task allocated to a processor is completed at the moment
            //remove this processor from working processors list
            //set this processor's working task to null
            //and make this processor waiting int the waiting queue
            //finished tasks are added to the completed tasks list
            for (Processor p : workingProcessors){
                if (currentTime - p.task.startTime == p.task.duration){
                    System.out.println("time:" + currentTime + " Processor " + p.No + " has completed " + p.task.name);
                    completedTasks.add(p.task);
                    p.task = null;
                    waitingProcessors.enqueue(p);
                    //to avoid ConcurrentModificationException
                    //add all processors to be removed to a temp list and later remove them
                    transitionProcessors.add(p);
                }
            }
            workingProcessors.removeAll(transitionProcessors);
            transitionProcessors.clear();
            //if there are tasks to do, making waiting processors working
            while (!tasks.isEmpty() && !waitingProcessors.isEmpty()) {
                Task nextTask = tasks.delMax();
                nextTask.startTime = currentTime;
                Processor nextProcessor = waitingProcessors.dequeue();
                nextProcessor.task = nextTask;
                workingProcessors.add(nextProcessor);
                System.out.println("time:" + currentTime + " Processor " + nextProcessor.No + " is working on " + nextTask.name);
            }
            currentTime++;
        }
        return currentTime - 1;
    }

    public static void main(String[] args) {
        //create random tasks
        ArrayList<Task> tasks = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            tasks.add(new Task("任务"+i, StdRandom.uniform(10,100)));;
        }
        //tasks.sort(Comparator.reverseOrder());
        System.out.println(tasks);
        //init lpt instance
        LPT lpt = new LPT();
        lpt.initProcessors(4);
        lpt.initTasks(tasks);
        //
        long time = lpt.run();
        System.out.println("total time spent: " + time);

    }


}
