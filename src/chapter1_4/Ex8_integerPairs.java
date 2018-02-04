package chapter1_4;

import java.util.Arrays;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_4
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/2/1/001 15:51
 * @UpdateDate: 2018/2/1/001 15:51
 */
public class Ex8_integerPairs {

    public static void main(String[] args) {

        int[] ints = {1,3,4,1,2,5,6,3,5,8,2,6,3};

        //N*N
        int count = 0;
        for (int i=0;i<ints.length;i++){
            for (int j = i+1;j<ints.length;j++)
                if (ints[i] == ints[j])
                    count++;
        }
        System.out.println(count);

        //lgN*N
        count = 0;
        Arrays.sort(ints);
        for(int j=0;j<ints.length;j++)
            if (Arrays.binarySearch(ints,ints[j]) > j)
                count++;
        System.out.println(count);
    }
}
