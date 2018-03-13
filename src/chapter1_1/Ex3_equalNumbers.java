package chapter1_1;

import edu.princeton.cs.algs4.StdIn;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/23/023 13:23
 * @UpdateDate: 2018/1/23/023 13:23
 */
class Ex3_equalNumbers {

    public static void main(String[] args) {

        int num1 = StdIn.readInt();
        int num2 = StdIn.readInt();
        int num3 = StdIn.readInt();

        if (num1 == num2 && num2 == num3)
            System.out.println("equal");
        else
            System.out.println("not equal");
    }
}
