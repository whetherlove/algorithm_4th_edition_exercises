package chapter1_4;

import java.util.Arrays;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_4
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/2/2/002 15:39
 * @UpdateDate: 2018/2/2/002 15:39
 */
public class Ex14_4sum {

    public static void main(String[] args) {

        int[] a = {-3,3,4,2,-7,-4,3,5,10,0};

        int count = 0;
        for (int i=0;i<a.length;i++)
            for (int j=i+1;j<a.length;j++)
                for (int k=j+1;k<a.length;k++)
                    if (Arrays.binarySearch(a,-a[i]-a[j]-a[k]) > k)
                        count++;
        System.out.println(count);
    }
}
