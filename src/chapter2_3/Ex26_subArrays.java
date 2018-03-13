package chapter2_3;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

import static chapter2_3.Quick.partition;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_3
 * @Description:
 * @date 1/03/2018 3:23 PM
 */
class Ex26_subArrays {

    private static final int M = 10; //20,50;
    private static final int[] subArrays = new int[M+2];

    private static void sort(Comparable[] a) {
        StdRandom.shuffle(a); // 消除对输入的依赖
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi - lo <= M){
            int length = hi - lo + 1;
            if (length > 0)
                subArrays[length]++;
            Insertion.sort(a,lo,hi);
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static void main(String[] args) {
        Comparable[] a = new Comparable[10000];
        for (int i = 0; i < a.length; i++)
            a[i] = StdRandom.uniform(10000);
        sort(a);
        System.out.println(Arrays.toString(subArrays));



    }
}
