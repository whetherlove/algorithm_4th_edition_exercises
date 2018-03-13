package chapter2_4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_4
 * @Description:
 * @date 6/03/2018 5:43 PM
 */
public class Ex3_sortedArray<Item extends Comparable<Item>> {

    private Item[] pq;

    private int N = 0;

    public Ex3_sortedArray(int max) {
        pq = (Item[]) new Comparable[max];
    }

    //不考虑pq满的情况
    public void insert(Item v) {
        if (N==0) pq[0] = v;
        int i = 0;
        for (; i< N; i++)
            if (v.compareTo(pq[i]) > 0)
                break;
        for (int j=N-1; j>=i; j--)
            pq[j+1] = pq[j];
        pq[i] = v;
        N++;
    }

    public Item max() {
        return pq[0];
    }

    public Item delMax() {
        Item max = max();
        for (int i=1;i<N;i++)
            pq[i-1] = pq[i];
        pq[N--] = null;
        return max;
    }

    public static void main(String[] args) {
        Ex3_sortedArray pq = new Ex3_sortedArray(5);
        pq.insert(2);
        pq.insert(1);
        pq.insert(4);
        pq.insert(3);
        System.out.println(pq.max());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
    }
}
