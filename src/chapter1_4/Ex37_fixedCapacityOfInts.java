package chapter1_4;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_4
 * @Description:
 * @date 6/02/2018 1:06 PM
 */
public class Ex37_fixedCapacityOfInts {

    public static void main(String[] args) {
        System.out.println("StackOfInts\tStackOfIntegers\tRatio");
        for (int n=250;;n*=2){
            long t0 = System.currentTimeMillis();
            StackOfInts ints = new StackOfInts(n);
            for (int i=0;i<n;i++)
                ints.a[i] = StdRandom.uniform(n);
            long t1 = System.currentTimeMillis();
            StackOfIntegers integers = new StackOfIntegers(n);
            for (int i=0;i<n;i++)
                integers.a[i] = StdRandom.uniform(n);
            long t2 = System.currentTimeMillis();

            long timeOfInts = t1-t0;
            long timeOfIntegers = t2 - t1;
            long ratio = timeOfInts == 0 ? 0 : timeOfIntegers/timeOfInts;
            System.out.println(timeOfInts + "\t\t\t" + timeOfIntegers + "\t\t\t\t" + ratio);
        }
    }
}

class StackOfInts{
    protected int[] a;
    private int N = 0;
    StackOfInts(int n){
        a = new int[n];
    }
    public void push(int i){
        a[N++] = i;
    }
    public int pop(){
        return a[N--];
    }
}

class StackOfIntegers{
    protected Integer[] a;
    private int N = 0;
    StackOfIntegers(int n){
        a = new Integer[n];
    }
    public void push(int i){
        a[N++] = i;
    }
    public int pop(){
        return a[N--];
    }
}