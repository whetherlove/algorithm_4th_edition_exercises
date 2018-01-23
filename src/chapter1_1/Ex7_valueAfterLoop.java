package chapter1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/23/023 13:51
 * @UpdateDate: 2018/1/23/023 13:51
 */
public class Ex7_valueAfterLoop {

    public static void main(String[] args) {

        double t = 9.0;
        while(Math.abs(t - 9.0/t) > .001)
            t = (9.0/t + t) / 2.0;
        StdOut.printf("%.5f\n", t);

        int sum = 0;
        for(int i=1;i<1000;i++){
            for (int j=0;j<i;j++){
                sum++;
            }
        }
        StdOut.println(sum);


    }
}
