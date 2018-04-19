import java.util.*;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: PACKAGE_NAME
 * @Description:
 * @date 28/03/2018 3:53 PM
 */
public class test {

    static void print(ArrayList a){
        a.add(2);
        a = new ArrayList();
        a.add(3);
        a.add(4);
        System.out.println(a);
}

    public static void main(String[] args) {
        Integer a = new Integer(10);
        Integer b = new Integer(10);
        System.out.println(a==b);
        System.out.println(a.equals(b));

    }
}

