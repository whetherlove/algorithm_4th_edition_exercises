package chapter1_1;

import edu.princeton.cs.algs4.StdIn;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/23/023 13:42
 * @UpdateDate: 2018/1/23/023 13:42
 */
class Ex5_doublesBetweenZeroAndOne {

    public static void main(String[] args) {

        double x = StdIn.readDouble();
        double y = StdIn.readDouble();

        if (x > 0 && x < 1 && y > 0 && y< 1)
            System.out.println("true");
        else
            System.out.println("false");
    }
}
