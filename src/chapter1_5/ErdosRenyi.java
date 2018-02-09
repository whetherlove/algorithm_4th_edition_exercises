package chapter1_5;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Scanner;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_5
 * @Description:
 * @date 8/02/2018 2:02 PM
 */
public class ErdosRenyi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("N:");
        int N = scanner.nextInt();
        System.out.print("T:");
        int T = scanner.nextInt();

        double avg = 0;
        for (int i = 0; i < T; i++) {
            avg += (double) count(N) / T;
        }

        //Ex21
        double target = N * Math.log(N) * 0.5;
        System.out.println("1/2NlnN:" + target);
        System.out.println("avg links:" + avg);

        //Ex22，23 数据量大时结果比较明显，数据量小时时间可能为0
        long t0 = System.currentTimeMillis();
        count(N);
        long t1 = System.currentTimeMillis();
        count(2*N);
        long t2 = System.currentTimeMillis();
        System.out.println("2N/N ratio:" + (t2-t1)/(t1-t0));
    }

    public static int count(int N){
        //通过更换代码 切换不同UF
        //QuickUnionUF uf = new QuickUnionUF();
        //WeightedQuickUnionUF uf = new WeightedQuickUnionUF();
        QuickFindUF uf = new QuickFindUF(N);
        int p,q,count = 0;
        while (uf.count() > 1){
            p = StdRandom.uniform(N);
            q = StdRandom.uniform(N);
            if (!uf.connected(p,q)){
                uf.union(p,q);
            }
            count++;
        }
        return count;
    }
}
