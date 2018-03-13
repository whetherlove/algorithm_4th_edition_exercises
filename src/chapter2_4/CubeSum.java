package chapter2_4;

import edu.princeton.cs.algs4.MinPQ;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_4
 * @Description:
 * @date 9/03/2018 12:57 PM
 */
public class CubeSum {

    private MinPQ<Entry> pq;

    private int N;

    private class Entry implements Comparable {

        private long sum;

        private int i;

        private int j;

        public Entry(int i, int j) {
            this.i = i;
            this.j = j;
            sum = i * i * i + j * j * j;
        }

        @Override
        public int compareTo(Object o) {
            return (int) (sum - ((Entry) o).sum);
        }

        @Override
        public String toString() {
            return "(" + sum + "," + i + "," + j + ")";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            if (sum != entry.sum) return false;
            if (i != entry.i) return false;
            return j == entry.j;
        }
    }

    public CubeSum(int N) {
        this.N = N;
        pq = new MinPQ<>();
        for (int i = 0; i <= N; i++)
            pq.insert(new Entry(i, 0));
    }

    // 由小到大打印所有a^3+b^3的结果, 其中a != b 且 a > b, 以避免重复录入
    public void print() {
        while (!pq.isEmpty()) {
            Entry temp = pq.delMin();
            System.out.println(temp);
            if (temp.j + 1 < temp.i)
                pq.insert(new Entry(temp.i, temp.j + 1));
        }
    }
    // 获取下一个最小值
    public Entry getMin(){
        Entry min = pq.delMin();
        if (min.j + 1 < min.i)
            pq.insert(new Entry(min.i, min.j + 1));

        return min;
    }

    public void findEquals() {
        ArrayList<Entry> list = new ArrayList<>();
        Entry current = getMin();
        list.add(current);
        while (!pq.isEmpty()) {
            Entry temp = getMin();
            while (!pq.isEmpty()) {
                if (temp.sum == current.sum) {
                    list.add(temp);
                    temp = getMin();
                }
                else
                    break;
            }
            if (list.size() > 1)
                getA_D(list);

            list.clear();
            current = temp;
            list.add(current);
        }
    }

    private void getA_D(ArrayList<Entry> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) {
        // test print()
        //CubeSum cubeSum = new CubeSum(10);
        //cubeSum.print();

        // test find()
        CubeSum cs = new CubeSum(100);
        cs.findEquals();
    }
}
