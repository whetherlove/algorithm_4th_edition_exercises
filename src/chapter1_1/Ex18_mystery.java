package chapter1_1;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/23/023 16:41
 * @UpdateDate: 2018/1/23/023 16:41
 */
class Ex18_mystery {

    public static void main(String[] args) {
        System.out.println(mystery(2,25));
        System.out.println(mystery(3,11));
        System.out.println(mystery2(2,25));
        System.out.println(mystery2(3,11));
    }

    private static int mystery(int a, int b){
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery(a+a,b/2);
        return mystery(a+a,b/2) + a;
    }
    private static int mystery2(int a, int b){
        if (b == 0) return 1;
        if (b % 2 == 0) return mystery(a*a,b/2);
        return mystery(a*a,b/2) * a;
    }
}
