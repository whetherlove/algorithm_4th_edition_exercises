package chapter1_1;

import edu.princeton.cs.algs4.StdIn;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/24/024 19:27
 * @UpdateDate: 2018/1/24/024 19:27
 */
class Ex39_matchByBinarySearch {

    public static void main(String[] args) {

        System.out.println("Enter how many times will the exp run:");
        int T = StdIn.readInt();

        double mean3 = 0;
        double mean4 = 0;
        double mean5 = 0;
        double mean6 = 0;

        for (int i=0;i<T;i++){
            mean3 += findCommon(1000) / (double)T;
            mean4 += findCommon(10000) / (double)T;
            mean5 += findCommon(100000) / (double)T;
            mean6 += findCommon(1000000) / (double)T;
        }

        System.out.println(mean3);
        System.out.println(mean4);
        System.out.println(mean5);
        System.out.println(mean6);


    }

    //array with elements from 100000 to 999999
    private static int[] initArray(int N){
        int[] a = new int[N];
        for (int i=0;i<N;i++)
            a[i] = (int)(Math.random()*99999 + 100000);
        return a;
    }
    private static int findCommon(int N){
        int[] a = initArray(N);
        int[] b = initArray(N);
        int count = 0;
        for (int i : a){
            //rank()是Ex38_bruteForceSearch里的binary Search方法
            if (Ex38_bruteForceSearch.rank(i,b)>0)
                count++;
        }
        return count;
    }
}
