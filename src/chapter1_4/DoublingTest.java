package chapter1_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_4
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/31/031 15:29
 * @UpdateDate: 2018/1/31/031 15:29
 */
public class DoublingTest {

    public static double timeTrial(int N){
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i=0;i<N;i++)
            a[i] = StdRandom.uniform(-MAX,MAX);
        StopWatch timer = new StopWatch();
        int count = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        for (int N = 250;;N += N){
            double time = timeTrial(N);
            StdOut.printf("%7d %5.1f\n", N,time);
        }
    }
}
