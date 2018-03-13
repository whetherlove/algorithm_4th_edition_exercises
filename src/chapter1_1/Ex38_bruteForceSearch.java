package chapter1_1;

import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/24/024 19:15
 * @UpdateDate: 2018/1/24/024 19:15
 */
@SuppressWarnings("Duplicates")
class Ex38_bruteForceSearch {
    public static void main(String[] args) {

        System.out.println("Enter the key:");
        int key = StdIn.readInt();
        System.out.println("Enter the array:");
        int[] whiteList = StdIn.readAllInts();

        long startTime_ = System.currentTimeMillis();
        int resultOfBrute = rank(key,whiteList);
        long endTime_ = System.currentTimeMillis();
        System.out.println("Time spent on brute force search:"+(endTime_-startTime_)+"ms");

        long startTime = System.currentTimeMillis();
        Arrays.sort(whiteList);
        int resultOfBinary = rank(key,whiteList);
        long endTime = System.currentTimeMillis();
        System.out.println("Time spent on binary search:"+(endTime-startTime)+"ms");



    }
    public static int bruteForceSearch(int key, int[] a){
        for (int i=0;i<a.length;i++){
            if (a[i] == key)
                return i;
        }
        return -1;
    }
    public static int rank(int key, int[] a){
        return rank(key,a,0,a.length-1);
    }
    private static int rank(int key, int[] a, int lo, int hi){
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank(key,a,lo,mid-1);
        else if (key > a[mid]) return rank(key,a,mid+1,hi);
        else return mid;
    }


}


