package chapter2_4;

import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.MinPQ;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_4
 * @Description:
 * @date 9/03/2018 7:46 PM
 */
class Ex30_medianPQ {
    //maxPQ用来储存队列中较小的一半的元素
    //minPQ用来储存队列中较大的一半的元素
    private final MaxPQ<Double> maxPQ = new MaxPQ<>();
    private final MinPQ<Double> minPQ = new MinPQ<>();

    private void insert(double d){
        if (minPQ.isEmpty()){
            minPQ.insert(d);
            return;
        }
        double median = minPQ.min();
        if (d >= median)
            minPQ.insert(d);
        if (d < median)
            maxPQ.insert(d);
        adjustPQ();
    }

    private void adjustPQ() {
        if (minPQ.size() - maxPQ.size() == 2)
            maxPQ.insert(minPQ.delMin());
        if (maxPQ.size() - minPQ.size() == 2)
            minPQ.insert(maxPQ.delMax());
    }

    public Double median(){
        return minPQ.min();
    }

    private Double delMedian(){
        Double d = minPQ.delMin();
        adjustPQ();
        return d;
    }

    public static void main(String[] args) {
        Ex30_medianPQ pq = new Ex30_medianPQ();
        for (int i = 0; i < 10; i++) {
            pq.insert(i);
        }
        System.out.println(pq.delMedian());
        System.out.println(pq.delMedian());
        System.out.println(pq.delMedian());
    }
}
