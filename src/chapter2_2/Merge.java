package chapter2_2;

import java.util.Arrays;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_2
 * @Description: 原地自顶向下归并 ~NlgN
 * @date 25/02/2018 9:14 AM
 */
public class Merge {
    //不在merge内部设置辅助数组，用以避免每次调用merge都生成新的数组
    private static Comparable[] aux;
    //统计访问数组总次数，对于长度为N的数组，复制2N次，移动2N次，比较最多2N次
    private static int times = 0;
    //Ex19 用于统计数组中的倒置数量
    private static int reversals = 0;

    private static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);
        times += a.length;
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if (hi <= lo) return;
        int mid = lo + (hi-lo) / 2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        if (less(a[mid+1],a[mid]))
            merge(a,lo,mid,hi);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k=lo; k<=hi; k++) {
            times++;
            aux[k] = a[k];
        }

        for (int k=lo; k<=hi; k++){
            times++;
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j],aux[i])) {
                a[k] = aux[j++];
                reversals += j - k - 1;
            }
            else
                a[k] = aux[i++];
        }
    }


    @SuppressWarnings("unchecked")
    public static boolean less(Comparable aux, Comparable aux1) {
        return aux.compareTo(aux1) < 0;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Comparable<String>[] a = new Comparable[]{"A", "E", "C", "B", "F"};
        sort(a);
        System.out.println(times);
        System.out.println(Arrays.toString(a));
        //Ex19 test
        System.out.println(reversals);
    }
}
