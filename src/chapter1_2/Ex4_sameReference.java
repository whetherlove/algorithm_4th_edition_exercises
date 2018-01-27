package chapter1_2;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_2
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/27/027 13:39
 * @UpdateDate: 2018/1/27/027 13:39
 */
public class Ex4_sameReference {

    public static void main(String[] args) {

        String s1 = "Hello";
        String s2 = s1;
        s1 = "World";
        System.out.println(s1);
        System.out.println(s2);
    }
}
