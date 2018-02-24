package chapter2_1;

import java.util.Arrays;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_1
 * @Description:
 * @date 23/02/2018 3:23 PM
 */
public class ShellSort {

    int times = 0;
    //希尔排序 不需要额外内存空间，适用于中等大小数组
    //在无系统排序函数可用时，可优先考虑希尔排序，再考虑快排
    //从小到大排序 相隔h的元素比较 h逐步减小至1
    public static void sort(double[] a){
        //time为总比较次数，返回值为平均比较次数，用于习题12
        int h = 1;
        while (h < a.length/3)
            h = h*3 + 1;
        while (h >=1 ){
            double time = 0;
            for (int i = h; i < a.length ; i++) {
                for (int j = i; j >=h && a[j] < a[j-h]; j-=h) {
                    time++;
                    double temp = a[j];
                    a[j] = a[j-h];
                    a[j-h] = temp;
                }
                time++;
            }
            System.out.println("h=" + h + " " + "ratio=" + time/a.length);
            h /= 3;
        }
    }

    public static void main(String[] args) {
        //Ex12
        for (int i=100;i<=100000;i*=10){
            System.out.println("ArraySize:" + i);
            double[] a = new double[i];
            for (int j=0;j<i;j++)
                a[j] = Math.random()*100;
            sort(a);
        }
    }
}
