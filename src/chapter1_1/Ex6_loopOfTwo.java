package chapter1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/23/023 13:49
 * @UpdateDate: 2018/1/23/023 13:49
 */
public class Ex6_loopOfTwo {

    public static void main(String[] args) {

        int f = 0;
        int g = 1;

        for (int i=0;i<=15;i++){
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }
}
