package chapter1_4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_4
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/31/031 14:59
 * @UpdateDate: 2018/1/31/031 14:59
 */
class ThreeSum {

    public static int count(int[] a){
        int N = a.length;
        int cnt = 0;

        for (int i=0;i<N;i++){
            for (int j=i+1;j<N;j++){
                for (int k=j+1;k<N;k++){
                    if (a[i]+a[j]+a[k] > Integer.MAX_VALUE)
                        throw new NumberFormatException();
                    if (a[i]+a[j]+a[k] == 0)
                        cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = StdIn.readAllInts();
        StdOut.println(count(a));
    }
}
