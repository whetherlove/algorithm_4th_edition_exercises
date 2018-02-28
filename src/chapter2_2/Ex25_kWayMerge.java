package chapter2_2;

import java.util.Arrays;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_2
 * @Description:
 * @date 27/02/2018 10:08 AM
 */
public class Ex25_kWayMerge {
    //构造一个适用于所有Comparable对象的变量INFINITE，令其比所有Comparable对象排序靠后
    private static Comparable INFINITE = new Comparable() {
        @Override
        public int compareTo(Object o) {
            return 0;
        }

        @Override
        public String toString() {
            return "INFINITE";
        }
    };

    // 重写less方法，令INFINITE大于任意Comparable对象
    public static boolean less(Comparable v, Comparable w) {
        if (v.equals(INFINITE))
            return false;
        if (w.equals(INFINITE))
            return true;
        return v.compareTo(w) < 0;
    }

    // 自底向上k路归并,a为需要排序的数组，k为归并算法每次归并的路数
    public static void sort(Comparable[] a, int k) {
        int N = a.length;
        for (int size = 1; size < N; size *= k) {
            for (int lo = 0; lo < N - size; lo += size * k) {
                if (!isSorted(a)) {
                    merge(a, lo, size, k);
                    System.out.println(Arrays.toString(a));
                }
            }
        }
    }

    private static boolean isSorted(Comparable[] a) {
        for (int i=1;i<a.length;i++)
            if (less(a[i],a[i-1]))
                return false;
        return true;
    }

    private static void merge(Comparable[] a, int lo, int size, int k) {
        // 建立一个candidate库，包含k路需要排序的子数组
        Comparable[][] candidates = new Comparable[k][size + 1];
        // 此处的嵌套循环最坏情况下 访问数组N次，时间复杂度~N
        // 子数组长度设为size+1,并将最后一位设为INFINITE,
        // 其作用在于若当前子数组耗尽，则该子数组最小值为INFINITE，
        // 由于INFINITE为无穷大，则该路相当于不再参与排序
        int current = lo;
        for (int i = 0; i < k; i++) {
            Comparable[] ith = new Comparable[size + 1];
            for (int j = 0; j < size; j++) {
                if (current > a.length - 1)
                    ith[j] = INFINITE;
                else
                    ith[j] = a[current++];
            }
            ith[size] = INFINITE;
            candidates[i] = ith;
        }
        for (Comparable[] c : candidates)
            System.out.println(Arrays.toString(c));
        // 使用一个记录各路当前排序位置的数组
        int[] pos = new int[k];
        for (int i = lo; i < Math.min(lo + size * k, a.length - 1); i++)
            a[i] = min(candidates, pos);

    }

    public static Comparable min(Comparable[][] c, int[] pos) {
        Comparable min = c[0][pos[0]];
        for (int i = 0; i < c.length; i++)
            if (less(c[i][pos[i]], min))
                min = c[i][pos[i]];
        for (int i = 0; i < c.length; i++)
            if (c[i][pos[i]].equals(min))
                pos[i]++;
        return min;
    }

    public static void main(String[] args) {
        Comparable<String>[] a = new Comparable[] { "A", "E", "C", "B", "F" };
        sort(a, 4);
        System.out.println(Arrays.toString(a));

    }
}
