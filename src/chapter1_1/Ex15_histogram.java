package chapter1_1;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/23/023 16:21
 * @UpdateDate: 2018/1/23/023 16:21
 */
@SuppressWarnings("SameParameterValue")
class Ex15_histogram {

    public static void main(String[] args) {

        int[] a = {1,2,3,4,5,5,5,7};
        int[] result = histogram(a,5);
        for (int i: result){
            System.out.println(i+" ");
        }
    }

    private static int[] histogram(int[] a, int M){
        int[] result = new int[M];
        for (int i=1;i<=result.length;i++){
            int num = 0;
            for (int anA : a)
                if (anA == i)
                    num++;
            result[i-1] = num;
        }
        return result;
    }
}
