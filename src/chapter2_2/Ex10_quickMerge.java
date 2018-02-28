package chapter2_2;

import java.util.Arrays;

import static chapter2_2.Merge.less;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_2
 * @Description:
 * @date 25/02/2018 10:48 AM
 */
public class Ex10_quickMerge {

    public static void sort(Comparable[] a){
        //Ex9,将aux作为参数传递
        Comparable[] aux = new Comparable[a.length];
        sort(a,aux,0,a.length-1);
    }

    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if (hi <= lo) return;
        int mid = lo + (hi-lo) / 2;
        sort(a,aux,lo,mid);
        sort(a,aux,mid+1,hi);
        if (less(a[mid+1],a[mid]))
            merge(a,aux,lo,mid,hi);
    }

    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        int i = lo;
        int j = hi;

        for (int k=lo; k<=mid; k++)
            aux[k] = a[k];
        //按降序将a[]的后半部分复制到aux
        for (int k=mid+1; k<=j; k++)
            aux[k] = a[hi+mid+1-k];

        for (int k=lo; k<=hi ;k++){
            if (less(aux[i],aux[j]))
                a[k] = aux[i++];
            else
                a[k] = aux[j--];
        }
    }

    public static void main(String[] args) {
        Comparable<String>[] a = new Comparable[]{"A", "E", "C", "B", "F", "D"};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
