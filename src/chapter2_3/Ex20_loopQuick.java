package chapter2_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.stream.Stream;

import static chapter2_3.Quick.partition;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_3
 * @Description:
 * @date 1/03/2018 9:10 AM
 */
public class Ex20_loopQuick {

    private static class Interval{
        private int lo;
        private int hi;
        Interval(int lo, int hi){
            this.lo = lo;
            this.hi = hi;
        }
    }
    private static Stack<Interval> stack = new Stack();

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a); // 消除对输入的依赖
        stack.push(new Interval(0,a.length-1));
        do {
            Interval i = stack.pop();
            if (i.hi > i.lo) {
                int j = partition(a, i.lo, i.hi);
                stack.push(new Interval(i.lo,j-1));
                stack.push(new Interval(j+1,i.hi));
            }
        }while (!stack.isEmpty());
    }

    public static void main(String[] args) {
        Double[] a = Stream.generate(Math::random).limit(100).toArray(Double[]::new);
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
