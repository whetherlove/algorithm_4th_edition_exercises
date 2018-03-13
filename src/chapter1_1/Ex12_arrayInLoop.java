package chapter1_1;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/23/023 15:36
 * @UpdateDate: 2018/1/23/023 15:36
 */
class Ex12_arrayInLoop {

    public static void main(String[] args) {

        int[] a = new int[10];
        for (int i=0;i<10;i++)
            a[i] = 9-i;
        for (int i=0;i<10;i++)
            a[i] = a[a[i]];
        for (int i=0;i<10;i++)
            System.out.println(i);

    }
}
