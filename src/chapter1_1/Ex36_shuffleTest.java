package chapter1_1;

import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/24/024 17:10
 * @UpdateDate: 2018/1/24/024 17:10
 */
public class Ex36_shuffleTest {

    public static void main(String[] args) {

        System.out.println("Enter the length of the array to be shuffled:");
        int m = StdIn.readInt();
        System.out.println("Enter the times the array to be shuffled:");
        int n = StdIn.readInt();
        int[] a = new int[m];

        int[] frequencies = new int[m];
        for (int num=0;num<m;num++)
            frequencies[num] = 0;

        for (int i=0;i<n;i++){
            init(a);
            shuffle(a);
            for (int j=0;j<m;j++){
                if (a[j] == i)
                    frequencies[j]++;
            }
            for (int k: a)
                System.out.print(k+" ");
            System.out.println();
        }

    }

    public static void init(int[] a){
        for (int i=0;i<a.length;i++){
            a[i] = i;
        }
    }
    public static void shuffle(int[] a){
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i: a)
            temp.add(i);
        Collections.shuffle(temp);
        for (int i=0;i<a.length;i++)
            a[i] = temp.get(i);
    }
}
