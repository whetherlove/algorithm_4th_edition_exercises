package chapter2_1;

import java.util.Arrays;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_1
 * @Description:
 * @date 20/02/2018 3:42 PM
 */
public class InsertionSort {

    // 插入排序 ~N^2 适用于部分有序的数组 和 小规模数组
    // 从小到大 相邻元素比较 每次循环将第i个数插入之前的有序数列
    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] a = { 4, 6, 8, 9, 1, 2, 4, 5 };
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
