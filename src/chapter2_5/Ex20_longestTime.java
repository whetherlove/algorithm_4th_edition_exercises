package chapter2_5;

import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_5
 * @Description:
 * @date 20/03/2018 4:53 PM
 */
public class Ex20_longestTime {

    //此题未说明处于等待序列的Task已何种顺序被执行，
    //此处按startTime从小到大执行，startTime相同时，按endTime由大到小执行
    //startTime已到 但未执行（无空闲processor）的任务将置于队列顶端

    private int numberOfProcessors;

    private int longestLeisureTime;
    private int longestBusyTime;

    private Queue<Task> tasks = new Queue<>();
    private int taskSize;
    private ArrayList<Task> completedTasks = new ArrayList<>();

    private Queue<Processor> waitingProcessors = new Queue<>();
    private ArrayList<Processor> workingProcessors = new ArrayList<>();
    private ArrayList<Processor> transitionProcessors = new ArrayList<>();

    private class Task implements Comparable{
        private int startTime;
        private int endTime;
        private int duration;
        private int actualStartTime;

        Task() {
            this.startTime = StdRandom.uniform(10);
            this.endTime = startTime + StdRandom.uniform(10,20);
            duration = endTime - startTime;
        }

        @Override
        public int compareTo(Object o) {
            Task t = (Task)o;
            return startTime==t.startTime?t.endTime-endTime:startTime-t.startTime;
        }

        @Override
        public String toString() {
            return "{" + startTime + "," +endTime + "}";
        }
    }

    private class Processor{
        Task current;

        public boolean isAvailable(){
            return current != null;
        }
    }

    private void init(int numberOfProcessors, int numberOfTasks){
        this.numberOfProcessors = numberOfProcessors;
        ArrayList<Task> list = new ArrayList<>();
        for (int i = 0; i < numberOfTasks; i++)
            list.add(new Task());
        list.sort(Comparator.naturalOrder());
        for (int i = 0; i < numberOfTasks; i++) {
            tasks.enqueue(list.get(i));
        }
        taskSize = numberOfTasks;
        for (int i = 0; i < numberOfProcessors; i++) {
            waitingProcessors.enqueue(new Processor());
        }
        System.out.println(tasks);
    }

    public void run(){
        int currentTime = 0;
        int tempLeisureTime = 0;
        int tempBusyTime = 0;
        while (completedTasks.size() != taskSize){
            for (Processor p : workingProcessors){
                if (currentTime - p.current.actualStartTime == p.current.duration){
                    completedTasks.add(p.current);
                    p.current = null;
                    waitingProcessors.enqueue(p);
                    transitionProcessors.add(p);
                }
            }
            workingProcessors.removeAll(transitionProcessors);
            transitionProcessors.clear();

            while (!tasks.isEmpty() && tasks.peek().startTime <= currentTime && !waitingProcessors.isEmpty()){
                Processor nextProcessor = waitingProcessors.dequeue();
                nextProcessor.current = tasks.dequeue();
                nextProcessor.current.actualStartTime = currentTime;
                workingProcessors.add(nextProcessor);
            }

            //manipulate longestLeisureTime and longestBusyTime
            if (workingProcessors.size() == numberOfProcessors)
                tempBusyTime++;
            else {
                if (tempBusyTime > longestBusyTime)
                    longestBusyTime = tempBusyTime;
                tempBusyTime = 0;
            }
            if (workingProcessors.size() == 0)
                tempLeisureTime++;
            else {
                if (tempLeisureTime > longestLeisureTime)
                    longestLeisureTime = tempLeisureTime;
                tempLeisureTime = 0;
            }
            currentTime++;
        }
    }

    public static void main(String[] args) {
        Ex20_longestTime time = new Ex20_longestTime();
        time.init(4, 10);
        time.run();
        System.out.println("longestBusyTime=" + time.longestBusyTime);
        System.out.println("longestLeisureTime=" + time.longestLeisureTime);
    }
}
