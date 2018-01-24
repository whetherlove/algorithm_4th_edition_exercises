package chapter1_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/24/024 11:18
 * @UpdateDate: 2018/1/24/024 11:18
 */
public class Ex28_deleteRepeatedElements {

    public static void main(String[] args) {

        int[] a = {1,2,3,3,3,3,3,3,4,5};

        Arrays.stream(a).distinct().forEach(System.out::println);

    }
}
