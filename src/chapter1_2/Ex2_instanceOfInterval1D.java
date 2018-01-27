package chapter1_2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_2
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/27/027 11:22
 * @UpdateDate: 2018/1/27/027 11:22
 */
public class Ex2_instanceOfInterval1D {

    public static void main(String[] args) {

        double[] inputs = {1,2,3,4,3,5};

        ArrayList<Interval1D> intervals = new ArrayList<>();
        for (int i = 0; i < inputs.length; i += 2)
            intervals.add(new Interval1D(inputs[i], inputs[i + 1]));

        for (int p = 0; p < intervals.size(); p++)
            for (int q = p + 1; q < intervals.size(); q++)
                if (intervals.get(p).intersects(intervals.get(q)))
                    System.out.println("{" + intervals.get(p).toString() + ","
                            + intervals.get(q).toString() + "}");

    }
}
