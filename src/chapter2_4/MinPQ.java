package chapter2_4;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_4
 * @Description:
 * @date 10/03/2018 10:16 AM
 */
public class MinPQ<Item extends Comparable<Item>> {

    private Item[] pq;
    private int N;

    public MinPQ(int max){
        pq = (Item[]) new Comparable[max+1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Item v) {
        pq[++N] = v;
        swim(N);
    }

    public Item delMin() {
        Item min = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return min;
    }

    private void swim(int k) {
        while (k > 1 && less(k, k/2)) {
            exch(k / 2, k);
            k /= 2;
        }
    }

    //Ex31
    //TODO
    private void swimWithBinarySearch(int k) {

    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
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

    private void exch(int i, int j) {
        Item temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;

    }

    //Ex15 检测是否为面向最小元素
    public boolean check(){
        for (int i = 1; i*2 < N; i++)
            if (less(i*2,i) || less(i*2+1,i))
                return false;
        return true;
    }

    public static void main(String[] args) {
        MinPQ pq = new MinPQ(10);
        pq.insert(2);
        pq.insert(1);
        pq.insert(4);
        pq.insert(3);
        //pq.insert(3);
        //pq.insert(4);

        //Ex15 test
        System.out.println(pq.check());

        System.out.println(pq.delMin());
        System.out.println(pq.delMin());
        System.out.println(pq.delMin());


    }

}
