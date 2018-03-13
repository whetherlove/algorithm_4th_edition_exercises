package chapter2_4;

import java.util.Arrays;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_4
 * @Description:
 * @date 12/03/2018 3:04 PM
 */
@SuppressWarnings({"Duplicates", "SameParameterValue"})
class IndexMinPQ<Key extends Comparable<Key>> {

    private int N; //PQ中的元素数量
    private final int[] pq;
    private final int[] qp;
    private final Key[] keys;

    @SuppressWarnings("unchecked")
    private IndexMinPQ(int max){
        keys = (Key[])new Comparable[max+1];
        pq = new int[max+1];
        qp = new int[max+1];
        Arrays.fill(qp,-1);
    }

    public boolean isEmpty(){
        return N==0;
    }

    public boolean contains(int k){
        return qp[k] != -1;
    }

    void insert(int k, Key key){
        N++;
        qp[k] = N;
        pq[N] = k;
        keys[k] = key;
        swim(N);
    }

    private void swim(int k) {
        while (k > 1 && less(k, k/2)) {
            exch(k / 2, k);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && less(j+1, j))
                j++;
            if (j < N && !less(j,k))
                break;
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j){
        return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
    }

    private void exch(int i, int j){
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    Key min(){
        return keys[pq[1]];
    }

    int delMin(){
        int indexOfMin = pq[1];
        exch(1,N--);
        sink(1);
        keys[pq[N+1]] = null;
        qp[pq[N+1]] = -1;
        return indexOfMin;
    }

    public int minIndex(){
        return pq[1];
    }

    public void change(int k, Key key){
        keys[k] = key;
        swim(qp[k]);
        sink(qp[k]);
    }

    public void delete(int k){
        int index = qp[k];
        exch(index,N--);
        swim(index);
        sink(index);
        keys[k] = null;
        qp[k] = -1;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        IndexMinPQ<Integer> pq = new IndexMinPQ(10);
        pq.insert(2,2);
        pq.insert(1,1);
        pq.insert(4,4);
        pq.insert(3,3);
        System.out.println(pq.min());
        System.out.println(pq.delMin());
        System.out.println(pq.min());
    }
}
