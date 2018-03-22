package chapter2_5;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_5
 * @Description:
 * @date 13/03/2018 3:09 PM
 */
public class Version implements Comparable{

    //version is represented by A.B.C
    private int A;
    private int B;
    private int C;

    public Version(int a, int b, int c) {
        A = a;
        B = b;
        C = c;
    }

    @Override
    public int compareTo(Object o) {
        Version v = (Version)o;
        return A - v.A == 0 ? B - v.B == 0 ? C - v.C : B - v.B : A - v.A;
    }

    public static void main(String[] args) {
        Version v1 = new Version(115,1,1);
        Version v2 = new Version(115,10,1);
        System.out.println(v1.compareTo(v2));
    }
}
