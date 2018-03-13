package chapter2_4;


import edu.princeton.cs.algs4.Heap;

import java.util.Arrays;

import static chapter2_3.Quick.less;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_4
 * @Description:
 * @date 7/03/2018 4:25 PM
 */
public class HeapSort {

    public static void sort(Comparable[] a) {
        int n = a.length-1;
        for (int k = n / 2; k >= 1; k--)
            sink(a, k, n);
        while (n > 1) {
            exch(a, 1, n--);
            sink(a, 1, n);
        }
    }

    private static void sink(Comparable[] a, int i, int n) {
        while (i * 2 <= n) {
            int j = i * 2;
            if (j < n && less(a[j], a[j + 1]))
                j++;
            if (!less(a[i], a[j]))
                break;
            exch(a, i, j);
            i = j;
        }
    }

    public static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Comparable[] a = {null,1,6,7,5,9,2,3};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
