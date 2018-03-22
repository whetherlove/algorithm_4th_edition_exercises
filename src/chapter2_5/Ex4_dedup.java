package chapter2_5;

import java.util.Arrays;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_5
 * @Description:
 * @date 13/03/2018 2:19 PM
 */
public class Ex4_dedup {

    public static String[] dedup(String[] a){
        return Arrays.stream(a).distinct().sorted().toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] a = {"1","4","4","2","5"};
        System.out.println(Arrays.toString(dedup(a)));
    }
}
