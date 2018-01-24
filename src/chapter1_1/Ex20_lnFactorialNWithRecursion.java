package chapter1_1;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/23/023 17:06
 * @UpdateDate: 2018/1/23/023 17:06
 */
public class Ex20_lnFactorialNWithRecursion {

    public static void main(String[] args) {

        System.out.println(lnFactorial(10));
    }

    //ln(N!) = ln(N) + ln(N-1) + ... + ln(1)
    public static double lnFactorial(int n){
        if (n == 1) return Math.log(1);
        return Math.log(n) + lnFactorial(n-1);
    }
}
