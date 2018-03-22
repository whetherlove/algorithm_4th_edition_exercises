package chapter2_5;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_5
 * @Description:
 * @date 13/03/2018 3:54 PM
 */
public class Domain implements Comparable{

    //a domain is defined by A.B.C
    private String A;
    private String B;
    private String C;

    public Domain(String d) {
        String[] t = d.split("\\.");
        A = t[0];
        B = t[1];
        C = t[2];
    }

    @Override
    public int compareTo(Object o) {
        Domain d = (Domain) o;
        return C.compareTo(((Domain) o).C) == 0 ?
                B.compareTo(((Domain) o).B) == 0 ?
                A.compareTo(((Domain) o).A) : B.compareTo(((Domain) o).B) : C.compareTo(((Domain) o).C);
    }

    public static void main(String[] args) {
        Domain d1 = new Domain("www.baidu.com");
        Domain d2 = new Domain("cs.prinston.edu");
        System.out.println(d1.compareTo(d2));
    }
}
