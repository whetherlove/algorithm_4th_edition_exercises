package chapter1_4;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_4
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/2/2/002 16:36
 * @UpdateDate: 2018/2/2/002 16:36
 */
class Ex17_farthestPair {

    public static void main(String[] args) {

        double a[] = {5.6,3.8,-1.0,-3.2,-2.8,-1.5,0.2,5,6.9};

        double min = Double.MAX_VALUE;
        double max = -Double.MAX_VALUE;

        for (double anA : a) {
            if (anA > max)
                max = anA;
            if (anA < min)
                min = anA;
        }
        System.out.println(min + " " + max);
    }
}
