package chapter2_4;

import java.util.Arrays;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_4
 * @Description:
 * @date 6/03/2018 4:42 PM
 */
@SuppressWarnings("SameParameterValue")
class MaxPQ<Item extends Comparable<Item>> {

    private Item[] pq; // 基于堆的完全二叉树

    private int N = 0; // 储存于pq[1..N]中，pq[0]没有使用

    private Item min;

    @SuppressWarnings("unchecked")
    public MaxPQ() {
        pq = (Item[]) new Comparable[1];
    }

    @SuppressWarnings("unchecked")
    private MaxPQ(int max) {
        pq = (Item[]) new Comparable[max + 1];
    }

    @SuppressWarnings("unchecked")
    private MaxPQ(Item[] a) {
        N = a.length;
        pq = (Item[]) new Comparable[N+1];
        for (int i = 0; i < N; i++) {
            if (min == null || a[i].compareTo(min) < 0)
                min = a[i];
            pq[i+1] = a[i];
        }
        for (int k = N / 2; k >= 1; k--)
            sink(k);
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    void insert(Item v) {
        if (min == null || v.compareTo(min) < 0)
            min = v;
        if(N == pq.length - 1)
            resize(pq.length*2);
        pq[++N] = v;
        swim(N);
    }
    //Ex22 动态调整数组大小
    @SuppressWarnings("unchecked")
    private void resize(int max){
        Item[] temp = (Item[]) new Comparable[max];
        System.arraycopy(pq, 0, temp, 0, N);
        pq = temp;
    }

    public Item max() {
        return pq[1];
    }

    Item delMax() {
        Item max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        if (N <= pq.length / 4)
            resize(pq.length/2);
        return max;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Item temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k /= 2;
        }
    }
    //Ex26
    private void swimWithoutExch(int k) {
        Item temp = pq[k];
        while (k > 1 && less(k / 2, k)) {
            pq[k] = pq[k/2];
            k /= 2;
        }
        pq[k] = temp;
    }

    //Ex13 避免检查j<N
    private void sink(int k) {
        while (k * 2 <= N - 1) {
            int j = k * 2;
            if (less(j, j + 1))
                j++;
            if (!less(k, j))
                break;
            exch(k, j);
            k = j;
        }
        if (k * 2 == N && less(k,N))
            exch(k,N);
    }

    //Ex26
    private void sinkWithoutExch(int k) {
        Item temp = pq[k];
        while (2*k <= N){
            int j = 2*k;
            if (j<N && less(j, j + 1))
                j++;
            if (!less(k, j))
                break;
            pq[k] = pq[j];
            k = j;
        }
        pq[k] = temp;
    }

    //Ex27 找出最小元素 要求所需时间与空间均为常数
    Item min(){
        return min;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        MaxPQ<Integer> pq = new MaxPQ<>(10);
        pq.insert(2);
        pq.insert(1);
        pq.insert(4);
        pq.insert(3);
        pq.insert(3);
        pq.insert(4);
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());

        //Ex18 test
        pq.insert(4);
        System.out.println(Arrays.toString(pq.pq));
        pq.insert(5);
        System.out.println(pq.delMax());
        System.out.println(Arrays.toString(pq.pq));

        pq.insert(5);
        pq.insert(5);
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(Arrays.toString(pq.pq));

        //Ex27 test
        System.out.println("min=" + pq.min());

        //Ex19 test
        Comparable[] a = {3,4,5,1,2,7};
        MaxPQ maxPQ = new MaxPQ(a);
        System.out.println(Arrays.toString(maxPQ.pq));

        //Ex27 test
        System.out.println("min=" + maxPQ.min());

    }

}
