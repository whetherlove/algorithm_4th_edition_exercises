package chapter1_1;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/23/023 16:37
 * @UpdateDate: 2018/1/23/023 16:37
 */
class Ex16_exR1 {

    public static void main(String[] args) {
        System.out.println(exR1(6));
    }

    private static String exR1(int n){
        if (n < 0) return "";
        return exR1(n-3) + n + exR1(n-2) + n;
    }
}
