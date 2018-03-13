package chapter2_4;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_4
 * @Description:
 * @date 6/03/2018 5:22 PM
 */
@SuppressWarnings("SameParameterValue")
class Ex3_unorderedArray<Item extends Comparable<Item>> {

    private final Item[] pq;

    private int N = 0;

    @SuppressWarnings("unchecked")
    private Ex3_unorderedArray(int max) {
        pq = (Item[]) new Comparable[max];
    }

    void insert(Item v) {
        pq[N++] = v;
    }

    Item max() {
        if (N == 0) return null;
        if (N == 1) return pq[0];
        Item max = pq[0];
        for (int i = 1; i < N; i++)
            if (pq[i].compareTo(max) > 0)
                max = pq[i];
        return max;
    }

    Item delMax(){
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

    @SuppressWarnings("unchecked")
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
