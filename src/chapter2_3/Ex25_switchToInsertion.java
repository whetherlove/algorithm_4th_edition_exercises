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
 * @date 1/03/2018 3:00 PM
 */
public class Ex25_switchToInsertion {

    private static int M;

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a); // 消除对输入的依赖
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi - lo <= M){
            Insertion.sort(a,lo,hi);
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static void main(String[] args) {
        ArrayList<Long> timeSpents = new ArrayList<>();
        for (int i=0;i<=30;i++){
            M = i;
            long t0 = System.currentTimeMillis();
            for (int N = 1000; N<= 1000000; N*=10){
                Comparable[] a = new Comparable[N];
                for (int j = 0; j < N; j++)
                    a[j] = StdRandom.uniform(100);
                sort(a);
            }
            long t1 = System.currentTimeMillis();
            timeSpents.add(t1-t0);
        }
        System.out.println(timeSpents);
    }
}
