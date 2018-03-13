package chapter2_3;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.stream.Stream;

import static chapter2_2.Ex11_improvedMerge.exch;
import static chapter2_2.Merge.less;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_3
 * @Description:
 * @date 28/02/2018 6:12 PM
 */
@SuppressWarnings({"Duplicates", "UnusedAssignment"})
class Ex18_quick3sample {

    private static void sort(Comparable[] a) {
        StdRandom.shuffle(a); // 消除对输入的依赖
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = getMedian(a, lo, hi);
        while (true) {
            while (less(a[++i], v))
                if (i == hi)
                    break;
            while (less(v, a[--j]))
                if (j == lo)
                    break;
            if (i >= j)
                break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    @SuppressWarnings("unchecked")
    private static Comparable getMedian(Comparable[] a, int lo, int hi) {
        int pos1 = StdRandom.uniform(lo, hi + 1);
        int pos2 = StdRandom.uniform(lo, hi + 1);
        int pos3 = StdRandom.uniform(lo, hi + 1);
        Comparable c1 = a[pos1];
        Comparable c2 = a[pos2];
        Comparable c3 = a[pos3];
        int mid = pos1;
        if (c1.compareTo(c2) >= 0)
            if (c2.compareTo(c3) >= 0)
                mid = pos2;
            else if (c1.compareTo(c3) >= 0)
                mid = pos3;
        if (c1.compareTo(c2) <= 0)
            if (c2.compareTo(c3) <= 0)
                mid = pos2;
            else if (c1.compareTo(c3) <= 0)
                mid = pos3;
        Comparable c = a[mid];
        exch(a, lo, mid);
        return c;
    }

    // Ex19 附加题 少于7次比较找出中位数
    private static int getMedian(int a, int b, int c, int d, int e){
        int temp;
        if (a > b) {
            temp = a;
            a = b;
            b = temp;
        }
        if (c > d) {
            temp = c;
            c = d;
            d = temp;
        }
        if (a > c){
            temp = a;
            a = c;
            c = temp;
            temp = b;
            b = d;
            d = temp;
        }
        //至此 a < b,c,d  a一定不为中位数
        //另有 c < d
        if (b > e) {
            temp = b;
            b = e;
            e = temp;
        }
        if (b > c){
            temp = b;
            b = c;
            c = temp;
            temp = d;
            d = e;
            e = temp;
        }
        //至此 b < c,d,e b一定不为中位数
        //另有 c < d
        if (c < e) return c;
        return e;
    }

    public static void main(String[] args) {
        Double[] a = Stream.generate(Math::random).limit(100).toArray(Double[]::new);
        sort(a);
        System.out.println(Arrays.toString(a));

        // Ex19 test
        int[] list = new int[5];
        for (int i = 0; i < 5; i++) {
            list[i] = StdRandom.uniform(100);
        }
        System.out.println(Arrays.toString(list));
        System.out.println("Median:" + getMedian(list[0],list[1],list[2],list[3],list[4]));
    }
}
