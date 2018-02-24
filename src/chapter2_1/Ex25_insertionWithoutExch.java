package chapter2_1;

import java.util.Arrays;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_1
 * @Description:
 * @date 24/02/2018 4:25 PM
 */
public class Ex25_insertionWithoutExch {

    public static void sort(int[] a){
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int j = i;
            for (; j > 0 && temp < a[j-1]; j--) {
                    a[j] = a[j-1];
            }
            a[j] = temp;
        }
    }

    public static void main(String[] args) {

        int[] a = {4,6,8,9,1,2,4,5};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
