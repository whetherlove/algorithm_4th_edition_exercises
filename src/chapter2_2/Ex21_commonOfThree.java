package chapter2_2;

import java.util.Arrays;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_2
 * @Description:
 * @date 27/02/2018 8:57 AM
 */
class Ex21_commonOfThree {

    private static String getCommon(String[] l1, String[] l2, String[] l3){
        //sort为线性对数级别
        Arrays.sort(l1);
        Arrays.sort(l2);
        Arrays.sort(l3);
        for (String aL1 : l1)
            if (Arrays.binarySearch(l2, aL1) > -1 && Arrays.binarySearch(l3, aL1) > -1)
                return aL1;
        return null;
    }

    public static void main(String[] args) {
        String[] l1 = {"A","C","D"};
        String[] l2 = {"B","E","C"};
        String[] l3 = {"C","A","G"};
        System.out.println(getCommon(l1,l2,l3));
    }
}
