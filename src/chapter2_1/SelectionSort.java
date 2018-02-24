package chapter2_1;

import edu.princeton.cs.algs4.StdDraw;

import java.lang.reflect.Array;
import java.util.Arrays;

import static edu.princeton.cs.algs4.StdDraw.BLACK;
import static edu.princeton.cs.algs4.StdDraw.show;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_1
 * @Description:
 * @date 20/02/2018 3:31 PM
 */
public class SelectionSort {

    //选择排序 ~N^2
    //从小到大 每个元素与剩下元素比较 每次循环将第i小的数换到前面第i位
    public static void sort(int[] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[j] < a[i]){
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
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

