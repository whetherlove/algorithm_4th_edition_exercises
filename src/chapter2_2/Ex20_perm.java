package chapter2_2;

import java.util.Arrays;

import static chapter2_2.Merge.less;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_2
 * @Description:
 * @date 26/02/2018 7:13 PM
 */
class Ex20_perm {

    private static int[] aux;

    //思路: 构建0-n的有序数组perm,依据a元素顺序排序perm,排序完成后则perm满足题意
    private static int[] getPerm(Comparable[] a) {
        aux = new int[a.length];
        int[] perm = new int[a.length];
        for (int i = 0; i < a.length; i++)
            perm[i] = i;
        getPerm(a, perm, 0, a.length - 1);
        return perm;
    }

    private static void getPerm(Comparable[] a, int[] perm, int lo, int hi) {
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        getPerm(a, perm, lo, mid);
        getPerm(a, perm, mid + 1, hi);
        if (less(a[mid + 1], a[mid]))
            merge(a, perm, lo, mid, hi);
    }

    private static void merge(Comparable[] a, int[] perm, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        System.arraycopy(perm, lo, aux, lo, hi + 1 - lo);

        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                perm[k] = aux[j++];
            else if (j > hi)
                perm[k] = aux[i++];
            else if (less(a[aux[j]], a[aux[i]]))
                perm[k] = aux[j++];
            else
                perm[k] = aux[i++];
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Comparable<String>[] a = new Comparable[] { "A", "E", "C", "B", "F" };
        System.out.println(Arrays.toString(getPerm(a)));
    }
}
