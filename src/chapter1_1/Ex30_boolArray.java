package chapter1_1;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/24/024 13:29
 * @UpdateDate: 2018/1/24/024 13:29
 */
class Ex30_boolArray {

    public static void main(String[] args) {

        int M = 5;
        int N = 3;
        boolean[][] a = primeArray(M,N);
        for (int i=0;i<M;i++){
            for (int j=0;j<N;j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

    }

    private static boolean isCoprime(int a, int b){
        return Ex24_commonDivisor.commonDivisor(a,b)==1;
    }
    private static boolean [][] primeArray(int M, int N){
        boolean[][] a = new boolean[M][N];
        for (int i=1;i<=M;i++){
            for (int j=1;j<=N;j++){
                a[i - 1][j - 1] = isCoprime(i, j);
            }
        }
        return a;
    }
}
