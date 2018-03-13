package chapter1_4;

import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_4
 * @Description:
 * @date 6/02/2018 3:43 PM
 */
@SuppressWarnings("InfiniteLoopStatement")
class Ex44_birthdayProblem {

    public static void main(String[] args) {

        System.out.println("sqrt(PI*N/2)\ti\tavg");
        int N = 1000;
        double avg = 0;
        for (int i = 1;;i++){
            ArrayList<Integer> list = new ArrayList<>();
            while (true){
                int r = StdRandom.uniform(N);
                if (list.contains(r))
                    break;
                list.add(r);
            }
            avg = (avg*(i-1) + list.size()) / i;
            System.out.printf("%2.1f\t\t%d\t%2.1f\n",Math.sqrt(Math.PI*N/2),list.size()+1,avg);
        }
    }
}
