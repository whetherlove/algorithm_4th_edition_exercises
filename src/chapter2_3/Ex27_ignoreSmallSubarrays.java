package chapter2_3;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;

import static chapter2_3.Quick.partition;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_3
 * @Description:
 * @date 1/03/2018 3:48 PM
 */
public class Ex27_ignoreSmallSubarrays {


    private static int M;

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a); // 消除对输入的依赖
        sort(a, 0, a.length - 1);
        Insertion.sort(a);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi - lo <= M){
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static void main(String[] args) {
        for (int i=1;i<=100000;i*=2){
            M = i;
            long t0 = System.currentTimeMillis();
                Comparable[] a = new Comparable[10000];
                for (int j = 0; j < a.length; j++)
                    a[j] = StdRandom.uniform(100);
                sort(a);
            long t1 = System.currentTimeMillis();
            System.out.println("M:" + i + "time:" + (t1-t0));
        }
        //测试用机 在M = 8192时运行时间比前一个M多了一个数量级，可见测试用机缓存大小在4096-8192之间
    }
}
