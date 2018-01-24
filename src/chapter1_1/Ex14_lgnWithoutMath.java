package chapter1_1;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/23/023 16:16
 * @UpdateDate: 2018/1/23/023 16:16
 */
public class Ex14_lgnWithoutMath {

    public static void main(String[] args) {

        int N = 65;
        System.out.println(lg(N));
    }

    public static int lg(int N){
        int result = 0;
        while(result * result <= N){
            result++;
        }
        return result-1;
    }
}
