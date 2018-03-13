package chapter1_4;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_4
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/2/2/002 14:32
 * @UpdateDate: 2018/2/2/002 14:32
 */
@SuppressWarnings("SameParameterValue")
class Ex10_binarySearch {

    public static void main(String[] args) {
        //test
        int[] a = {1,2,3,3,3,3,3,4,5,6,7,8};
        System.out.println(rank(3,a));
    }

    private static int rank(int key, int[] a){
        return rank(key,a,0,a.length-1);
    }
    private static int rank(int key, int[] a, int lo, int hi){
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank(key,a,lo,mid-1);
        else if (key > a[mid]) return rank(key,a,mid+1,hi);
        else
            return rank(key,a,lo,mid-1) == -1 ? mid : rank(key,a,lo,mid-1);
    }
}
