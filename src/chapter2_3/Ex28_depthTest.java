package chapter2_3;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdRandom;

import static chapter2_3.Quick.partition;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_3
 * @Description:
 * @date 1/03/2018 4:01 PM
 */
public class Ex28_depthTest {

    private static int M = 10; //20 50

    public static int sort(Comparable[] a) {
        StdRandom.shuffle(a); // 消除对输入的依赖
        int depth = 0;
        depth = sort(a, depth, 0, a.length - 1);
        return depth;
    }

    public static int sort(Comparable[] a, int depth, int lo, int hi) {
        if (hi - lo <= M){
            Insertion.sort(a,lo,hi);
            return depth + 1;
        }
        int j = partition(a, lo, hi);
        int depthLeft = sort(a, depth, lo, j - 1);
        int depthRight = sort(a, depth,j + 1, hi);
        if (depthLeft > depthRight)
            return depthLeft + 1;
        return depthRight + 1;
    }

    public static void main(String[] args) {
        for (int N = 1000; N < 1000000; N*=10) {
            Comparable[] a = new Comparable[N];
            for (int i = 0; i < a.length; i++)
                a[i] = i;
            StdRandom.shuffle(a);
            System.out.println("N:" + N + " depth:" + sort(a));
        }

    }
}
