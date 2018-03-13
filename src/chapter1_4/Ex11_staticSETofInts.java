package chapter1_4;

import java.util.Arrays;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_4
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/2/2/002 14:37
 * @UpdateDate: 2018/2/2/002 14:37
 */
@SuppressWarnings("SameParameterValue")
class Ex11_staticSETofInts {

    private final int[] a;
    private Ex11_staticSETofInts(int[] keys){
        a = new int[keys.length];
        System.arraycopy(keys, 0, a, 0, keys.length);
        Arrays.sort(a);
    }

    public boolean contains(int key){
        return rank(key) != -1;
    }

    private int rank(int key){
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi){
            int mid = (hi - lo) / 2 +lo;
            if (key <a[mid])
                hi = mid - 1;
            if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    private int howMany(int key){
        return rankHi(key) - rankLo(key) + 1;
     }

    private int rankLo(int key){
        return rankLo(key,0,a.length-1);
    }
    private int rankLo(int key, int lo, int hi){
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rankLo(key,lo,mid-1);
        else if (key > a[mid]) return rankLo(key,mid+1,hi);
        else
            return rankLo(key,lo,mid-1) == -1 ? mid : rankLo(key,lo,mid-1);
    }

    private int rankHi(int key){
        return rankHi(key,0,a.length-1);
    }
    private int rankHi(int key, int lo, int hi){
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rankHi(key,lo,mid-1);
        else if (key > a[mid]) return rankHi(key,mid+1,hi);
        else
            return rankHi(key,mid+1,hi) == -1 ? mid : rankHi(key,mid+1,hi);
    }

    public static void main(String[] args) {

        int[] a = {1,2,3,3,3,3,3,4,5,6,7,8};
        Ex11_staticSETofInts seTofInts = new Ex11_staticSETofInts(a);
        System.out.println(seTofInts.howMany(3));
    }
}
