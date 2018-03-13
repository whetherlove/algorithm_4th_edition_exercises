package chapter1_1;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/24/024 17:09
 * @UpdateDate: 2018/1/24/024 17:09
 */
class Ex35_dice {

    public static void main(String[] args) {

        int SIDES = 6;
        double[] dist = new double[2 * SIDES + 1];
        for (int i = 1; i <= SIDES; i++) {
            for (int j = 1; j <= SIDES; j++) {
                dist[i + j] += 1.0;
            }
        }
        for (int k = 2; k <= 2 * SIDES; k++) {
            dist[k] /= 36.0;
        }
        //set N
        int N = 10000000;

        int[] count = new int[2 * SIDES + 1];
        for (int i=0;i<N;i++){
            count[sumOfTwo()]++;
        }

        double[] distInExp = new double[2 * SIDES + 1];
        for (int k = 2; k <= 2 * SIDES; k++) {
            distInExp[k] = count[k] / (double)N;
        }

        System.out.println(isAccurate(dist,distInExp));
    }

    private static int sumOfTwo(){
        int a = (int)(Math.random()*5 + 1);
        int b = (int)(Math.random()*5 + 1);
        return a+b;
    }

    private static boolean isAccurate(double[] dist, double[] distInExp){
        for (int i=0;i<dist.length;i++)
            if (dist[i] - distInExp[i] < 0.001)
                return true;
        return false;
    }
}
