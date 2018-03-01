package chapter2_2;

import java.util.Arrays;

import static chapter2_2.Merge.less;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_2
 * @Description:
 * @date 25/02/2018 12:03 PM
 */
public class Ex11_improvedMerge {

    public static void sort(Comparable[] a){
        //改进3：将aux作为参数传递
        Comparable[] aux = new Comparable[a.length];
        sort(a,aux,0,a.length-1);
    }

    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if (hi <= lo) return;
        int mid = lo + (hi-lo) / 2;

        //改进1：对于小数组直接采用其他排序方法
        if (hi - lo <= 2)
            for (int i=lo+1; i<=hi; i++)
                for (int j = i; j > lo && less(a[j], a[j - 1]); j--)
                    exch(a,j, j - 1);
        else {
            sort(a, aux, lo, mid);
            sort(a, aux, mid + 1, hi);

            //改进2 判断是否有序
            if (less(a[mid + 1], a[mid]))
                Ex10_quickMerge.merge(a, aux, lo, mid, hi);
        }
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void main(String[] args) {
        Comparable<String>[] a = new Comparable[]{"A", "E", "C", "B", "F", "D"};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
