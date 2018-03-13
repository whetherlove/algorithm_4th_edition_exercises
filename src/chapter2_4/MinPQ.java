package chapter2_4;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_4
 * @Description:
 * @date 10/03/2018 10:16 AM
 */
@SuppressWarnings({"SameParameterValue", "Duplicates"})
class MinPQ<Item extends Comparable<Item>> {

    private final Item[] pq;
    private int N;

    @SuppressWarnings("unchecked")
    private MinPQ(int max){
        //noinspection unchecked
        pq = (Item[]) new Comparable[max+1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void insert(Item v) {
        pq[++N] = v;
        swim(N);
    }

    private Item delMin() {
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
    private void swimWithBinarySearch(int k) {
        //构建包含目标元素祖先节点下标的数组
        int n = 0;
        while (k/2 >= 1){
            k/=2;
            n++;
        }
        int[] parentArray = new int[n];
        int index = n-1;
        for (int i = k/2; i >=1 ; i/=2)
            parentArray[index--] = i;
        //使用二分法寻找祖先节点
        int lo = 0, hi = n-1;
        int mid = (hi - lo) / 2 + lo;
        while (lo < hi){
            mid = (hi - lo) / 2 + lo;
            if (less(parentArray[mid],k))
                lo = mid + 1;
            else if (less(k,parentArray[mid]))
                hi = mid;
        }
        //进行交换
        while (k > parentArray[mid]){
            exch(k,k/2);
            k/=2;
        }
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
    private boolean check(){
        for (int i = 1; i*2 < N; i++)
            if (less(i*2,i) || less(i*2+1,i))
                return false;
        return true;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        MinPQ pq = new MinPQ(10);
        //noinspection unchecked
        pq.insert(2);
        //noinspection unchecked
        pq.insert(1);
        //noinspection unchecked
        pq.insert(4);
        //noinspection unchecked
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
