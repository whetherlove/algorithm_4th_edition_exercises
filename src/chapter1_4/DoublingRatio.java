package chapter1_4;

import java.util.Scanner;

import static chapter1_4.DoublingTest.*;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_4
 * @Description:
 * @date 6/02/2018 1:24 PM
 */
@SuppressWarnings("InfiniteLoopStatement")
class DoublingRatio {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        double prev = timeTrial(125);
        for (int N =250;;N+=N){
            double avg = 0;
            for (int i=0;i<times;i++)
                avg += timeTrial(N) / times;
            System.out.printf("%6d %7.1f ",N,avg);
            System.out.printf("%5.1f\n",avg/prev);
            prev = avg;
        }
    }
}
