package chapter1_2;

import java.util.Arrays;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_2
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/27/027 19:17
 * @UpdateDate: 2018/1/27/027 19:17
 */
class Ex18_accumulator {

    private double m;
    private double s;
    private int N;

    private void addDateValue(double x){
        N++;
        s = s + 1.0 * (N - 1) / N * (x - m) * (x -m );
        m = m + (x - m) / N;
    }

    public double mean(){
        return m;
    }

    private double var(){
        return s / (N - 1);
    }

    private double stddev(){
        return Math.sqrt(this.var());
    }

    public static void main(String[] args) {

        double[] doubles = {1.1,2.5,3.0,4.7,5.5};
        double mean = Arrays.stream(doubles).average().getAsDouble();

        //直接求标准差
        double sttdev = 0;
        for (double d : doubles)
            sttdev += (d - mean) * (d - mean);
        System.out.println(Math.sqrt(sttdev/(doubles.length-1)));

        //使用accumulator求标准差
        Ex18_accumulator accumulator = new Ex18_accumulator();
        for (Double d : doubles)
            accumulator.addDateValue(d);
        System.out.println(accumulator.stddev());
    }
}
