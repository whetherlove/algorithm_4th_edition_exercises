package chapter1_4;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_4
 * @Description:
 * @date 6/02/2018 4:05 PM
 */
@SuppressWarnings("InfiniteLoopStatement")
class Ex45_couponProblem {

    public static void main(String[] args) {
        //Hn指的是调和级数 Harmonic series  1, 1/2, 1/3 ... 1/n
        int N = 1000;
        double NHN = 1000 * HN(N);
        System.out.println("HN\t\ti\t\tavg");
        double avg = 0;
        for (int i = 1;;i++){
            boolean[] a = new boolean[N];
            int n = 0;
            while (!allTrue(a)){
                int r = StdRandom.uniform(N);
                a[r] = true;
                n++;
            }
            avg = (avg*(i-1) + n) / i;
            System.out.printf("%2.1f\t\t%d\t%2.1f\n",NHN,n+1,avg);
        }
    }

    private static boolean allTrue(boolean[] a){
        for (boolean b : a)
            if (!b)
                return false;
        return true;
    }

    private static double HN(int N){
        double sum = 0;
        for (double i=1;i<=N;i++)
            sum += 1 / i;
        return sum;
    }
}
