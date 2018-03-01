package chapter2_3;

import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static chapter2_2.Ex11_improvedMerge.exch;
import static chapter2_2.Merge.less;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_3
 * @Description:
 * @date 1/03/2018 10:48 AM
 */
public class Ex24_sampleQuick {

    /*
    此题题意不明，暂放

    按照此题所述，每次讲samples的中位数作为切分点，
    samples中位数左右两侧元素作为切分后子数组的切分点，
    在最坏条件下，例如对长度为N的数组的取样正好为数组中最小的X个，则可以计算递归深度 2^k-1 = X;
    由于比取样中位数小的元素数量为lt = X/2个，比取样中位数大的元素数量为 gt = N - X/2个
    则应有递归深度 k 必须大于 Max（lt,gt）才能保证完全排序
    e.g. N = 10,
    若取样大小为X = 7， 则由X计算得出 k = 3, 然而 递归深度 = Max（lt,gt）= 6不满足完全排序条件
    最坏情况下，a = {1,2,3,4,5,6,7,8,9,10} samples = {1,2,3,4,5,6,7} 无法将a完全排序
    若k=4，X = 15 > N = 10, 导致oversampling问题，等于将所有元素过一遍，不如直接将a[lo]作为切分点

    维基百科中 SampleSort被描述为
    1.Sample p−1 elements from the input (the splitters).
    2.Sort these; each pair of adjacent splitters then defines a bucket.
    3.Loop over the data, placing each element in the appropriate bucket.
    Sort each of the buckets.
    即将数组元素 置于每2个相邻样品构成的桶内,
    p依据实际情况可取>=2的任意值（通常依据处理器数量）
    样本排序为桶排序的改良版，每个桶的大小相同

    与题意比较相符的描述为http://www.netlib.org/utk/lsi/pcwLSI/text/node302.html
    其中提到了2^d-1 splitting keys，d为递归深度， 该方法用于多处理器平行排序
    in the concurrent algorithm, the splitting keys are chosen with some care.
    One reasonable way to do this is to randomly sample a subset of the entire
    list (giving an estimate of the true distribution of the list) and then pick
    splitting keys based upon this sample. To save time, all 2^k-1 splitting keys
    are found at once. This modified algorithm should perhaps be called samplesort
    and consists of the following steps:

    1.each processor picks sample of l items at random;
    2.sort the sample of  items using the parallel shellsort;
    3.choose splitting keys as if this was the entire list;
    4.broadcast  splitting keys so that all processors know all splitting keys;
    5.perform the splits in the d directions of the hypercube;
    6.each processor quicksorts its sublist.
     */
    public static ArrayList<Comparable> sampling(Comparable[] a){
        ArrayList<Comparable> samples = new ArrayList<>();
        //k值无法确定 此题暂放
        int k = 1;
        for (int i = 0; i < k; i++)
            samples.add(a[i]) ;
        Collections.sort(samples);
        System.out.println(samples);
        return samples;
    }

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a); // 消除对输入的依赖
        ArrayList<Comparable> samples = sampling(a);
        sort(a, samples, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, ArrayList<Comparable> samples, int lo, int hi) {
        System.out.println("lo:" + lo + " hi:" + hi);
        if (hi <= lo)
            return;
        int j = partition(a, samples, lo, hi);
        //以j为分割点将sample划分为前后2部分
        ArrayList<Comparable> samplesLo = new ArrayList<>();
        for (int i = 0; i < samples.size()/2; i++)
            samplesLo.add(samples.get(i));
        ArrayList<Comparable> samplesHi = new ArrayList<>();
        for (int i = samples.size()/2 + 1; i < samples.size(); i++)
            samplesHi.add(samples.get(i));
        System.out.println(Arrays.toString(a));
        sort(a, samplesLo, lo, j - 1);
        sort(a, samplesHi,j + 1, hi);
    }

    public static int partition(Comparable[] a, ArrayList<Comparable> samples, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = samples.get(samples.size()/2);
        int vPos = lo;
        for (int k = lo+1; k <= hi; k++)
            if (a[k] == v)
                vPos = k;
        exch(a,lo,vPos);
        while (true) {
            while (less(a[++i], v))
                if (i == hi)
                    break;
            while (less(v, a[--j]))
                if (j == lo)
                    break;
            if (i >= j)
                break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static void main(String[] args) {
        Comparable[] a = new Comparable[10];
        for (int i = 0; i < a.length; i++)
            a[i] = StdRandom.uniform(100);
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
