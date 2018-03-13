package chapter1_1;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/23/023 19:14
 * @UpdateDate: 2018/1/23/023 19:14
 */
@SuppressWarnings("SameParameterValue")
class Ex27_binomial {

    static int count = 0;

    public static void main(String[] args) {

        System.out.println(binomial(1,1,0.25));
        System.out.println(binomial(2,2,0.25));
        System.out.println(binomial(100,50,0.25));
    }

//    public static double binomial(int n, int k, double p){
//        count++;
//        if (n == 0 && k == 0) return 1.0;
//        if (n < 0 || k < 0) return 0.0;
//        double result = (1.0-p)*binomial(n-1,k,p)+p*binomial(n-1,k-1,p);
//        pnk[n][k] = result;
//        return result;
//    }
    //使用for代替递归
    private static double binomial(int n, int k, double p){
        //pnk[n][k]为n次试验目标事件发生k次的概率
        double[][] pnk = new double[n+1][k+1];
        pnk[0][0] = 1.0;
        pnk[1][0] = 1.0 - p;
        for (int i=1;i<=n;i++){
            for (int j=1;j<=Math.min(i,k);j++){
                pnk[i][j] = (1.0-p)*pnk[i-1][j] + p*pnk[i-1][j-1];
            }
        }
        return pnk[n][k];
    }
}
