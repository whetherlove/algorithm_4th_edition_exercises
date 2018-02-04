package chapter1_4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_4
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/2/2/002 16:09
 * @UpdateDate: 2018/2/2/002 16:09
 */
public class Ex16_closestPair {

    public static void main(String[] args) {

        double a[] = {5.6,3.8,-1.0,-3.2,-2.8,-1.5,0.2,5,6.9};
        //Arrays.sort(a)排序为线性对数级别，下面的查找为线性级别
        Arrays.sort(a);
        double min = Double.MAX_VALUE;
        double one = 0;
        double two = 0;
        for (int i=1;i<a.length;i++){
            double dif = Math.abs(a[i] - a[i-1]);
            if (dif < min){
                min = dif;
                one = a[i-1];
                two = a[i];
            }
        }
        System.out.println(one + " " + two);
    }
}
