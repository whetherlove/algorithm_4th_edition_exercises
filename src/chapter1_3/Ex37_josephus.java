package chapter1_3;

import java.util.stream.Stream;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/29/029 15:47
 * @UpdateDate: 2018/1/29/029 15:47
 */
public class Ex37_josephus {

    public static void main(String[] args) {

        int N = 7;
        int M = 2;

        CircularList<Integer> list = new CircularList<>();
        for (int i=0;i<N;i++)
            list.add(i);
        System.out.println(list);

        while (!list.isEmpty()){
            list.passCurrentBy(M);
            System.out.println(list.getCurrent());
        }

    }
}
