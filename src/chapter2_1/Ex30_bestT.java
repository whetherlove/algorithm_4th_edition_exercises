package chapter2_1;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_1
 * @Description:
 * @date 24/02/2018 4:38 PM
 */
class Ex30_bestT {

    private static void sort(double[] a, int t){

        int h = 1;
        while (h*h < a.length)
            h *= t;
        while (h >= 1 ){
            for (int i = h; i < a.length ; i++) {
                for (int j = i; j >=h && a[j] < a[j-h]; j-=h) {
                    double temp = a[j];
                    a[j] = a[j-h];
                    a[j-h] = temp;
                }
            }
            h /= t;
        }
    }

    public static void main(String[] args) {

        double[] a = Ex17_animation.generate(1000000);

        for (int t = 2; t < 1000; t++) {
            double[] b = a.clone();
            long t0 = System.currentTimeMillis();
            sort(b,t);
            long t1 = System.currentTimeMillis();
            System.out.println("t=" + t + " time=" + (t1-t0)/1000.0);
        }
    }
}
