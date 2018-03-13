package chapter2_4;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_4
 * @Description:
 * @date 12/03/2018 3:33 PM
 */
class Sample {

    private final double[] p;
    private final double[] subT;
    private double T;

    public Sample(double[] p){
        this.p = p;
        T = Arrays.stream(p).sum();
        subT = new double[p.length];
        double localSum = 0;

        for (int i = 0; i < p.length; i++) {
            localSum += p[i];
            subT[i] = localSum;
        }
    }
    //以p[i]/T的概率返回i
    //例如对于数组{4，3，2，1}
    //有40%概率返回1
    //有30%概率返回2
    //有20%概率返回3
    //有10%概率返回4
    //暂不会使用树来做
    //FIXME
    public int random(){
        double r = StdRandom.uniform(0,T);
        for (int i = 0; i < subT.length; i++) {
            if (subT[i] > r)
                return i;
        }
        return -1;
    }

    public void change(int i, double v){
        int N = subT.length;
        for (int j = i; j < N; j++) {
            subT[i] = subT[i] - p[i] + v;
        }
        T = subT[N-1];
        p[i] = v;
    }
}
