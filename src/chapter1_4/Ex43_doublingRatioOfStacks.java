package chapter1_4;

import chapter1_3.ResizingArrayStack;
import chapter1_3.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_4
 * @Description:
 * @date 6/02/2018 3:32 PM
 */
public class Ex43_doublingRatioOfStacks {

    public static void main(String[] args) {

        ResizingArrayStack<Integer> stack1 = new ResizingArrayStack<>();
        Stack<Integer> stack2 = new Stack<>();
        System.out.println("StackOfArray\tStackOfNode\t\tRatio");
        for (int N = 250;;N += N){
            long t0 = System.currentTimeMillis();
            for (int i=0;i<N;i++){
                stack1.push(i);
            }
            long t1 = System.currentTimeMillis();
            for (int j=0;j<N;j++){
                stack2.push(j);
            }
            long t2 = System.currentTimeMillis();

            long timeOfInts = t1-t0;
            long timeOfIntegers = t2 - t1;
            long ratio = timeOfInts == 0 ? 0 : timeOfIntegers/timeOfInts;
            System.out.println(timeOfInts + "\t\t\t\t" + timeOfIntegers + "\t\t\t\t" + ratio);
        }
    }
}
