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
 * @date 28/02/2018 5:24 PM
 */
@SuppressWarnings({"ConstantConditions", "StatementWithEmptyBody"})
class Ex17_quickWithSentry {

    private static void sort(Comparable[] a) {
        StdRandom.shuffle(a); // 消除对输入的依赖
        //将数组中最大的元素置于数组最右端
        Comparable max = Arrays.stream(a).reduce((c1,c2) -> less(c1,c2)?c2:c1).get();
        for (int i=0;i<a.length;i++)
            if (a[i].equals(max))
                exch(a,i,a.length-1);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int j = partition(a, lo, hi);
        //将子数组右端一位包含进来
        sort(a, lo, j);
        sort(a, j + 1, Math.min(hi+1,a.length-1));
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v));
            while (less(v, a[--j]));
            if (i >= j)
                break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static void main(String[] args) {
        Double[] a = Stream.generate(Math::random).limit(100).toArray(Double[]::new);
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
