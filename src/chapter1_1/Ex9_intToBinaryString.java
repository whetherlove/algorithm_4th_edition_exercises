package chapter1_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/23/023 14:52
 * @UpdateDate: 2018/1/23/023 14:52
 */
class Ex9_intToBinaryString {

    public static void main(String[] args) {

        int n = StdIn.readInt();

        StdOut.println(Integer.toBinaryString(n));

        StringBuilder s = new StringBuilder();
        for (int i=n;i>0;i/=2)
            s.insert(0, (i % 2));

        System.out.println(s);
    }
}
