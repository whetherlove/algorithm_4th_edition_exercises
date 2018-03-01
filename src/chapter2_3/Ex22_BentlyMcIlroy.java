package chapter2_3;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

import static chapter2_2.Ex11_improvedMerge.exch;
import static chapter2_3.Ex18_quick3sample.getMedian;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_3
 * @Description:
 * @date 1/03/2018 9:27 AM
 */
public class Ex22_BentlyMcIlroy {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a); // 消除对输入的依赖
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int p = lo, i = lo + 1, q = hi, j = hi;
        Comparable v = a[lo];
        while (true) {
            while (a[i].compareTo(v) <= 0) {
                if (i == hi)
                    break;
                if (a[i].compareTo(v) == 0)
                    exch(a, i++, p++);
                else
                    i++;
            }
            while (a[j].compareTo(v) >= 0) {
                if (j == lo)
                    break;
                if (a[j].compareTo(v) == 0)
                    exch(a, j--, q--);
                else
                    j--;
            }
            if (i >= j)
                break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    public static void main(String[] args) {
        Comparable[] a = new Comparable[10];
        for (int i = 0; i < a.length; i++)
            a[i] = StdRandom.uniform(100);
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
