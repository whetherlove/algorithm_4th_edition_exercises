package chapter1_2;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_2
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/27/027 13:37
 * @UpdateDate: 2018/1/27/027 13:37
 */
public class Ex6_circularRotation {

    public static void main(String[] args) {
        String s = "GCTTGACA";
        String t = "ACAGCTTG";
        System.out.println(isCircular(s,t));
    }
    public static boolean isCircular(String s, String t){
        return s.length() == t.length() && s.concat(s).indexOf(t) >=0;
    }
}
