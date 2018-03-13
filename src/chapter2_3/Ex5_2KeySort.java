package chapter2_3;

import java.util.Arrays;

import static chapter2_2.Ex11_improvedMerge.exch;
import static chapter2_2.Merge.less;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_3
 * @Description:
 * @date 28/02/2018 11:50 AM
 */
class Ex5_2KeySort {
    //两主键排序  使用三向切分快排思路 但仅需排一次即可  ~O(N)
    private static void sort(Comparable[] a) {
        int lo = 0, hi = a.length-1;
        if (hi <= lo)
            return;
        int lt = lo, i = lo + 1, gt = hi;
        while (i <= gt) {
            if (less(a[i],a[lo]))
                exch(a, lt++, i++);
            if (less(a[lo],a[i]))
                exch(a, i, gt--);
            else
                i++;
        }
    }

    public static void main(String[] args) {
        Comparable[] a = { 1, 2, 1, 1, 2, 2, 1, 1, 2, 1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
