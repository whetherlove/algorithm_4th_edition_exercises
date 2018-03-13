package chapter1_1;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/23/023 18:35
 * @UpdateDate: 2018/1/23/023 18:35
 */
@SuppressWarnings({"Duplicates", "SameParameterValue"})
class Ex22_binarySearch {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(rank(3,a));
    }
    private static int rank(int key, int[] a){
        return rank(key,a,0,a.length-1);
    }
    private static int rank(int key, int[] a, int lo, int hi){
        System.out.println("lo="+lo+" hi="+hi);
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank(key,a,lo,mid-1);
        else if (key > a[mid]) return rank(key,a,mid+1,hi);
        else return mid;
    }
}
