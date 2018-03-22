package chapter2_5;

import edu.princeton.cs.algs4.StdRandom;

import static chapter2_3.Quick.partition;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_5
 * @Description: 不完全排序找到第K小的元素
 * @date 13/03/2018 8:42 AM
 */
class FindK {
    //利用快排原理，找到第K位即停止
    public static Comparable select(Comparable[] a, int k) {
        StdRandom.shuffle(a);
        int lo = 0, hi = a.length - 1;
        while (lo < hi) {
            int j = partition(a, lo, hi);
            if (j == k)
                return a[k];
            else if (j > k)
                hi = j - 1;
            else if (j < k)
                lo = j + 1;
        }
        return a[k];
    }

    //Ex6 递归实现select
    public static Comparable selectRecursive(Comparable[] a, int k) {
        if (k >= a.length) return null;
        StdRandom.shuffle(a);
        int lo = 0, hi = a.length-1;
        return select(a,k,lo,hi);
    }

    public static Comparable select(Comparable[] a, int k, int lo, int hi) {
        int j = partition(a, lo, hi);
        if (j == k)
            return a[k];
        if (j > k)
            return select(a,k,lo,j-1);
        return select(a,k,j+1,hi);

    }

    //Ex23 题意即使用取样代替原来每次使用数列第一位位数进行partition
    //实现同取样快排

    public static void main(String[] args) {
        Comparable[] a = {1,4,5,7,2,3};
        System.out.println(select(a,1));
        System.out.println(selectRecursive(a,1));
    }
}
