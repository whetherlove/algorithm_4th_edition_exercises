package chapter1_1;

import java.util.ArrayList;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/23/023 16:51
 * @UpdateDate: 2018/1/23/023 16:51
 */
public class Ex19_fibonacci {

    public static void main(String[] args) {

        long[] value = new long[100];

        for (int N=0;N<100;N++){
            value[N] = F(N);
            System.out.println(N+" "+value[N]);
        }
    }
//    public static long F(int N){
//        if (N == 0) return 0;
//        if (N == 1) return 1;
//        return F(N-1) + F(N-2);
//    }
    public static long F(int N){
        if (N == 0) return 0;
        if (N == 1) return 1;
        long[] fib = new long[N+1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i=2;i<=N;i++)
            fib[i] = fib[i-1] + fib[i-2];
        return fib[N];
    }
}
