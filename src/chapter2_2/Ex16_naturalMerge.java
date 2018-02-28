package chapter2_2;

import java.util.Arrays;

import static chapter2_2.Merge.less;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_2
 * @Description:
 * @date 25/02/2018 2:38 PM
 */
public class Ex16_naturalMerge {
    //对于Ex17，将数组操作替换为LinkedList操作即可，a.get(i), a.set(i,k);
    public static void sort(Comparable[] a){

        int start1=0,end1=0,start2,end2;
        //找出第一个有序子数组
        while (less(a[end1],a[end1+1]) && end1 < a.length-1) {
            end1++;
            if (end1 == a.length-1)
                return;
        }
        //循环找出下一个有序子数组，和第一个子数组合并
        while (end1 != a.length-1){
            start2 = end1+1;
            end2 = start2;
            while (less(a[end2],a[end2+1]) && end1 < a.length-1) {
                end2++;
                if (end2 == a.length-1)
                    break;
            }
            merge(a,start1,end1,start2,end2);
            end1 = end2;
        }
    }

    public static void merge(Comparable[] a, int start1, int end1, int start2, int end2){
        int pos1 = start1, pos2 = start2;
        Comparable[] aux = new Comparable[end2-start1+1];
        for (int i=start1; i<=end2; i++)
            aux[i] = a[i];
        for (int pos=start1; pos<=end2; pos++){
            if (pos1 > end1)
                a[pos] = aux[pos2++];
            else if (pos2 > end2)
                a[pos] = aux[pos1];
            else if (less(aux[pos1],aux[pos2]))
                a[pos] = aux[pos1++];
            else
                a[pos] = aux[pos2++];
        }
    }

    public static void main(String[] args) {
        Comparable[] a = new Comparable[]{"A", "E", "C", "B", "F"};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
