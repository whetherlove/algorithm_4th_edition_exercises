package chapter2_3;

import edu.princeton.cs.algs4.StdRandom;

import static chapter2_2.Ex11_improvedMerge.exch;
import static chapter2_2.Merge.less;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_3
 * @Description: Quicksort with RandomSplitter, used in Ex29, Ex30
 * @date 1/03/2018 4:39 PM
 */
public class QuickRandomSplitter {

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        int r = StdRandom.uniform(lo,hi+1);
        Comparable v = a[r];
        exch(a,lo,r);
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
}
