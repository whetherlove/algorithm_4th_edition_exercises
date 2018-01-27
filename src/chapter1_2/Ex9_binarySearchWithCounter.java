package chapter1_2;

import edu.princeton.cs.algs4.Counter;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_2
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/27/027 13:56
 * @UpdateDate: 2018/1/27/027 13:56
 */
public class Ex9_binarySearchWithCounter {

    public static void main(String[] args) {
        Counter counter = new Counter("binarySearch");
        int[] a = {2,3,5,61,3,4,88};
        int pos = rank(3,a,counter);
        System.out.println(counter.tally());
    }
    public static int rank(int key, int[] a, Counter counter){
        return rank(key,a,0,a.length-1, counter);
    }
    public static int rank(int key, int[] a, int lo, int hi, Counter counter){
        counter.increment();
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank(key,a,lo,mid-1,counter);
        else if (key > a[mid]) return rank(key,a,mid+1,hi,counter);
        else return mid;
    }
}
