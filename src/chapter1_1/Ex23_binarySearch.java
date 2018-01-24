package chapter1_1;

import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/23/023 18:54
 * @UpdateDate: 2018/1/23/023 18:54
 */
public class Ex23_binarySearch {
    public static void main(String[] args) {
        
        System.out.println("Enter the filter parameter(+/-):");
        String p = StdIn.readLine();
        System.out.println("Enter the keys you want to test, separate with space:");
        String keys[] = StdIn.readLine().split(" ");
        
        int[] a = {1,2,3,4,5,6,7,8,9,10};

        if (p.equals("+")){
            Arrays.stream(keys)
                    .filter(e -> rank(Integer.parseInt(e),a)>=0)
                    .forEach(System.out::println);
        }
        if (p.equals("-")){
            Arrays.stream(keys)
                    .filter(e -> rank(Integer.parseInt(e),a)<0)
                    .forEach(System.out::println);
        }
    }

    public static int rank(int key, int[] a){
        return rank(key,a,0,a.length-1);
    }
    public static int rank(int key, int[] a, int lo, int hi){
        System.out.println("lo="+lo+" hi="+hi);
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank(key,a,lo,mid-1);
        else if (key > a[mid]) return rank(key,a,mid+1,hi);
        else return mid;
    }
}
