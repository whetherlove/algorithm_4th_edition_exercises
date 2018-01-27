package chapter1_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/27/027 8:50
 * @UpdateDate: 2018/1/27/027 8:50
 */
public class Ex37_badShuffle {

    public static void main(String[] args) {

        System.out.println("Enter the length of the array to be shuffled:");
        int m = StdIn.readInt();
        System.out.println("Enter the times the array to be shuffled:");
        int n = StdIn.readInt();
        int[] a = new int[m];

        int[][] frequencies = new int[m][m];

        for (int i=0;i<n;i++){
            init(a);
            badShuffle(a);
            for (int j=0;j<m;j++){
                int fallIn = a[j];
                frequencies[j][fallIn]++;
            }
        }

        for (int row=0;row<m;row++){
            System.out.print("shuffled times:" + (row+1) + " result: ");
            for (int col=0;col<m;col++){
                System.out.print(frequencies[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void init(int[] a){
        for (int i=0;i<a.length;i++){
            a[i] = i;
        }
    }
    public static void badShuffle(int[] a){
        for (int i=0;i<a.length;i++){
            int pos = StdRandom.uniform(a.length);
            int temp = a[i];
            a[i] = a[pos];
            a[pos] = temp;
        }
    }
}
