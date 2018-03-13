package chapter2_4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_4
 * @Description:
 * @date 6/03/2018 5:22 PM
 */
public class Ex3_unorderedArray<Item extends Comparable<Item>> {

    private Item[] pq;

    private int N = 0;

    public Ex3_unorderedArray(int max) {
        pq = (Item[]) new Comparable[max];
    }

    public void insert(Item v) {
        pq[N++] = v;
    }

    public Item max() {
        if (N == 0) return null;
        if (N == 1) return pq[0];
        Item max = pq[0];
        for (int i = 1; i < N; i++)
            if (pq[i].compareTo(max) > 0)
                max = pq[i];
        return max;
    }

    public Item delMax(){
        if (N == 0) return null;
        if (N == 1) return pq[0];
        Item max = max();
        for (int i = 0; i < N; i++) {
            if (pq[i] == max) {
                pq[i] = pq[--N];
                pq[N] = null;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Ex3_unorderedArray<Integer> pq = new Ex3_unorderedArray(5);
        pq.insert(2);
        pq.insert(1);
        pq.insert(4);
        pq.insert(3);
        System.out.println(pq.max());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());

    }
}
