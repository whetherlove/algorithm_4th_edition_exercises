package chapter1_4;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_4
 * @Description:
 * @date 4/02/2018 7:13 PM
 */
class Ex20_bitonicSearch {

    public static void main(String[] args) {

        int[] a = {1,2,3,4,5,6,7,11,10,9,8};
        System.out.println(findPeak(a));
        System.out.println(bitonicSearch(a,3));
        System.out.println(bitonicSearch(a,0));
    }
    //寻找最大值 ~lgN
    private static int findPeak(int[] a){
        int lo = 0;
        int hi = a.length - 1;
        return findPeak(a, lo, hi);
    }
    private static int findPeak(int[] a, int lo, int hi){
        int mid = (hi - lo) / 2 + lo;
        if (mid == 0 || mid == a.length)
            return -1;
        else if (a[mid] > a[mid-1] && a[mid] > a[mid+1])
            return mid;
        else if (a[mid] > a[mid-1])
            return findPeak(a,mid+1,hi);
        else
            return findPeak(a,lo,mid-1);
    }
    //以最大值为界将数组分为两个单调数组，分别使用二分法，~2lgN
    private static int bsLeft(int[] a, int key, int lo, int hi){
        if (lo > hi) return -1;
        int mid = (hi - lo) / 2 + lo;
        if (a[mid] == key)
            return mid;
        else if (a[mid] > key)
            return bsLeft(a,key,lo,mid-1);
        else if (a[mid] < key)
            return bsLeft(a,key,mid+1,hi);
        return -1;
    }
    private static int bsRight(int[] a, int key, int lo, int hi){
        if (lo > hi) return -1;
        int mid = (hi - lo) / 2 + lo;
        if (a[mid] == key)
            return mid;
        else if (a[mid] < key)
            return bsRight(a,key,lo,mid-1);
        else if (a[mid] > key)
            return bsRight(a,key,mid+1,hi);
        return -1;
    }
    //合并以上方法
    private static boolean bitonicSearch(int[] a, int key){
        int peak = findPeak(a);
        return bsLeft(a, key, 0, peak) != -1 || bsRight(a, key, peak, a.length - 1) != -1;
    }
}
