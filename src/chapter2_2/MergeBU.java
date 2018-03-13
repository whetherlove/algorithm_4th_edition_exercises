package chapter2_2;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_2
 * @Description:原地自底向上归并 ~NlgN
 * @date 25/02/2018 9:37 AM
 */
class MergeBU {

    public static void sort(Comparable[] a){
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for (int size = 1; size < N; size*=2)
            for (int lo=0; lo<N-size; lo+=size+size)
            Merge.merge(a,lo,lo+size-1,Math.min(lo+size+size-1,N-1));
    }
}
