package chapter2_3;

import edu.princeton.cs.algs4.StdRandom;

import static chapter2_2.Ex11_improvedMerge.exch;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_3
 * @Description:
 * @date 28/02/2018 11:31 AM
 */
public class Quick3Way {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a); // 消除对输入的依赖
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0)
                exch(a, lt++, i++);
            if (cmp > 0)
                exch(a, i, gt--);
            else
                i++;
        }
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }
}
