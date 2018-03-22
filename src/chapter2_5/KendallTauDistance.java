package chapter2_5;

import chapter2_2.Merge;

import java.util.Arrays;

import static chapter2_2.Ex11_improvedMerge.exch;
import static chapter2_3.Quick.less;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_5
 * @Description:
 * @date 13/03/2018 4:42 PM
 */
public class KendallTauDistance {

    private static int[] aux;
    private static int count = 0;

    public static int distance(Comparable[] a, Comparable[] b) {
        //check if a equals b
        Comparable[] aCopy = Arrays.copyOf(a,a.length);
        Comparable[] bCopy = Arrays.copyOf(b,b.length);
        Arrays.sort(aCopy);
        Arrays.sort(bCopy);
        if (!Arrays.equals(aCopy, bCopy))
            throw new IllegalArgumentException();
        //calculate the KendallTau Distance between a and b
        int N = a.length;
        //获取a,b数组中元素相对顺序的index数组
        //indexA[i]表示第i个元素在原数组中由小到大排第几位
        int[] indexA = new int[N];
        for (int i = 0; i < N; i++) {
            indexA[i] = Arrays.binarySearch(aCopy,a[i]);
        }
        int[] indexB = new int[N];
        for (int i = 0; i < N; i++) {
            indexB[i] = Arrays.binarySearch(bCopy,b[i]);
        }
        System.out.println(Arrays.toString(indexA));
        System.out.println(Arrays.toString(indexB));
        //至此转变为求2个由0到N-1构成的int数组的KendallTau Distance
        return distance(indexA,indexB);
    }

    /**
     * 求两个由0到N-1构成的int数组的KendallTau Distance
     * @param int[] a
     * @param int[] b
     * @return KendallTau Distance
     */
    public static int distance(int[] a, int[] b) {
        int[] aIndex = new int[a.length];
        int[] bIndex = new int[b.length];
        //用数组aIndex存储数组a的索引值,可以看做
        //aIndex[i]表示第i大的数在原数组中的位置
        for (int i=0;i<a.length;i++){
            aIndex[a[i]] = i;
        }
        System.out.println(Arrays.toString(aIndex));
        //bIndex数组引用A数组的索引，即bIndex数组存储b数组元素在a数组中的对应位置
        //bIndex[i]表示b[i]在a[i]中的位置
        for (int i=0;i<b.length;i++){
            bIndex[i]=aIndex[b[i]];
        }
        System.out.println(Arrays.toString(bIndex));
        //使用chapter2.2.19方法统计bIndex的倒置数量
        //使用归并排序 ~NlogN
        return countReversals(bIndex);
    }

    private static int countReversals(int[] a) {
        aux = new int[a.length];
        countReversals(a,0,a.length-1);
        return count;
    }

    private static void countReversals(int[] a, int lo, int hi){
        if (hi <= lo) return;
        int mid = lo + (hi-lo) / 2;
        countReversals(a,lo,mid);
        countReversals(a, mid+1,hi);
        if (less(a[mid+1],a[mid]))
            merge(a,lo,mid,hi);
    }

    public static void merge(int[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k=lo; k<=hi; k++) {
            aux[k] = a[k];
        }

        for (int k=lo; k<=hi; k++){
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j],aux[i])) {
                a[k] = aux[j++];
                count += j - k - 1;
            }
            else
                a[k] = aux[i++];
        }
    }

    public static void main(String[] args) {

        Comparable[] a = {"A","D","B","G","C","F","E"};
        Comparable[] b = {"B","A","D","G","E","C","F"};
        System.out.println(distance(a,b));
    }
}
