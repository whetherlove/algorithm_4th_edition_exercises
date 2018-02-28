package chapter2_2;

import java.util.Arrays;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_2
 * @Description:
 * @date 27/02/2018 8:57 AM
 */
public class Ex21_commonOfThree {

    public static String getCommon(String[] l1, String[] l2, String[] l3){
        //sort为线性对数级别
        Arrays.sort(l1);
        Arrays.sort(l2);
        Arrays.sort(l3);
        for (int i=0;i<l1.length;i++)
            //binarySearch为对数级别
            if (Arrays.binarySearch(l2,l1[i]) > -1 && Arrays.binarySearch(l3,l1[i]) > -1)
                return l1[i];
        return null;
    }

    public static void main(String[] args) {
        String[] l1 = {"A","C","D"};
        String[] l2 = {"B","E","C"};
        String[] l3 = {"C","A","G"};
        System.out.println(getCommon(l1,l2,l3));
    }
}
