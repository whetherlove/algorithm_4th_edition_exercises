package chapter2_4;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_4
 * @Description:
 * @date 6/03/2018 5:43 PM
 */
@SuppressWarnings("SameParameterValue")
class Ex3_sortedArray<Item extends Comparable<Item>> {

    private final Item[] pq;

    private int N = 0;

    @SuppressWarnings("unchecked")
    private Ex3_sortedArray(int max) {
        pq = (Item[]) new Comparable[max];
    }

    //不考虑pq满的情况
    private void insert(Item v) {
        if (N==0) pq[0] = v;
        int i = 0;
        for (; i< N; i++)
            if (v.compareTo(pq[i]) > 0)
                break;
        System.arraycopy(pq, i, pq, i + 1, N - i);
        pq[i] = v;
        N++;
    }

    private Item max() {
        return pq[0];
    }

    private Item delMax() {
        Item max = max();
        System.arraycopy(pq, 1, pq, 0, N - 1);
        pq[N--] = null;
        return max;
    }

    @SuppressWarnings("unchecked")
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
