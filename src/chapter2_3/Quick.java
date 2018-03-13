package chapter2_3;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.stream.Stream;

import static chapter2_2.Ex11_improvedMerge.exch;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_3
 * @Description:
 * @date 28/02/2018 10:58 AM
 */
public class Quick {

    private static int times;

    private static int subArray0;

    private static int subArray1;

    private static int subArray2;

    private static void sort(Comparable[] a) {
        StdRandom.shuffle(a); // 消除对输入的依赖
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi < lo)
            subArray0++;
        if (hi == lo)
            subArray1++;
        if (hi - lo == 1)
            subArray2++;
        if (hi <= lo)
            return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
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
            times++;
        }
        exch(a, lo, j);
        return j;
    }

    @SuppressWarnings("unchecked")
    public static boolean less(Comparable v, Comparable w) {
        times++;
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        // Ex6
        for (int N = 100; N <= 10000; N *= 10) {
            // 初始化测试数组
            Double[] a = Stream.generate(Math::random).limit(N).toArray(Double[]::new);
            sort(a);
            System.out.println("CN:" + times + " 2NlnN:" + 2 * N * Math.log(N));
            times = 0;
        }
        System.out.println();
        // Ex7
        subArray0 = 0;
        subArray1 = 0;
        subArray2 = 0;
        for (int N = 10; N <= 1000; N *= 2) {
            // 初始化测试数组
            Double[] a = Stream.generate(Math::random).limit(N).toArray(Double[]::new);
            sort(a);
            System.out.println("N:" + N + " 0:" + subArray0 + " 1:" + subArray1 + " 2:" + subArray2);
            subArray0 = 0;
            subArray1 = 0;
            subArray2 = 0;
        }
        System.out.println();
        // Ex8
        times = 0;
        for (int N = 10; N <= 10000; N *= 2) {
            // 初始化测试数组
            Comparable[] a = new Comparable[N];
            Arrays.fill(a,1);
            sort(a);
            System.out.println("N:" + N + " CN:" + times);
            times = 0;
        }
        // Ex16 有序数组即可
    }
}
