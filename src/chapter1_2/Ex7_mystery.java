package chapter1_2;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_2
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/27/027 13:47
 * @UpdateDate: 2018/1/27/027 13:47
 */
public class Ex7_mystery {

    public static void main(String[] args) {
        String s = "hello world";
        System.out.println(mystery(s));
    }
    public static String mystery(String s){
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0,N/2);
        String b = s.substring(N/2,N);
        return mystery(b) + mystery(a);
    }
}
