package chapter1_1;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/23/023 19:04
 * @UpdateDate: 2018/1/23/023 19:04
 */
class Ex24_commonDivisor {
    public static void main(String[] args) {
        System.out.println(commonDivisor(1111111,1234567));
    }
    public static int commonDivisor(int p, int q){
        System.out.println("p="+p+" q="+q);
        if (q == 0) return p;
        int r = p % q;
        return commonDivisor(q,r);
    }
}
