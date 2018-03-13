package chapter1_1;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/23/023 19:08
 * @UpdateDate: 2018/1/23/023 19:08
 */
class Ex26_rankOfThree {
    public static void main(String[] args) {
        int a=3,b=5,c=4;
        rank(a,b,c);
    }
    private static void rank(int a, int b, int c){
        if (a>b) {int t=a;a=b;b=t;}
        if (a>c) {int t=a;a=c;c=t;}
        if (b>c) {int t=b;b=c;c=t;}
        System.out.println(a<=b && b<=c);
    }

}
