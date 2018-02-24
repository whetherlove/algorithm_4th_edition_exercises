package chapter2_1;

import java.util.Arrays;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_1
 * @Description:
 * @date 24/02/2018 4:17 PM
 */
public class Ex24_insertionWithSentry {

    public static void sort(int[] a){
        //先找最小值
        int min = a[0];
        int minPos = 0;
        for (int i=1; i<a.length; i++){
            if (a[i] < min){
                min = a[i];
                minPos = i;
            }
        }
        //将最小值置于数组最左边
        if (minPos != 0){
            int temp = a[0];
            a[0] = a[minPos];
            a[minPos] = temp;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = i; a[j] < a[j-1]; j--) {
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
            }
        }
    }

    public static void main(String[] args) {

        int[] a = {4,6,8,9,1,2,4,5};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
