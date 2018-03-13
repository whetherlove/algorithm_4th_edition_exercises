package chapter2_4;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.MaxPQ;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_4
 * @Description:
 * @date 9/03/2018 7:38 PM
 */
public class Ex29_maxAndMinPQ<Item extends Comparable<Item>> {

    private MinPQ<Item> minPQ = new MinPQ<>();
    private MaxPQ<Item> maxPQ = new MaxPQ<>();
    private int size = 0;

    public void insert(Item item){
        size++;
        minPQ.insert(item);
        maxPQ.insert(item);
    }

    public Item delMax(){
        if (size > 0) {
            size--;
            return maxPQ.delMax();
        }
        return null;
    }

    public Item delMin(){
        if (size > 0) {
            size--;
            return minPQ.delMin();
        }
        return null;
    }

    public Item max(){
        if (size > 0)
            return maxPQ.max();
        return null;
    }

    public Item min(){
        if (size > 0)
            return minPQ.min();
        return null;
    }

    public static void main(String[] args) {
        Ex29_maxAndMinPQ pq = new Ex29_maxAndMinPQ();
        for (int i = 0; i < 10; i++) {
            pq.insert(i);
        }
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.delMin());
        System.out.println(pq.delMin());
    }
}
