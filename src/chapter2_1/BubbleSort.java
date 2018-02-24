package chapter2_1;

import java.util.Arrays;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_1
 * @Description:
 * @date 20/02/2018 4:02 PM
 */
public class BubbleSort {

    //冒泡排序 ~N^2
    //从小到大排序 相邻元素比较 每次循环将最大的换到末尾
    public static void sort(int[] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length-i; j++) {
                if (a[j] < a[j-1]) {
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] a = {4,6,8,9,1,2,4,5};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
