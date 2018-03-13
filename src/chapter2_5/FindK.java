package chapter2_5;

import edu.princeton.cs.algs4.StdRandom;

import static chapter2_3.Quick.partition;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_5
 * @Description: 不完全排序找到第K小的元素
 * @date 13/03/2018 8:42 AM
 */
class FindK {

    public static Comparable select(Comparable[] a, int k) {
        StdRandom.shuffle(a);
        int lo = 0, hi = a.length - 1;
        while (lo < hi) {
            int j = partition(a, lo, hi);
            if (j == k)
                return a[k];
            else if (j > k)
                hi = j - 1;
            else if (j < k)
                lo = j + 1;
        }
        return a[k];
    }
}
