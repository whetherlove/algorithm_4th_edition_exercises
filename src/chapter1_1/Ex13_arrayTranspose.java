package chapter1_1;

import java.util.stream.Stream;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/23/023 15:52
 * @UpdateDate: 2018/1/23/023 15:52
 */
public class Ex13_arrayTranspose {

    public static void main(String[] args) {

        int[][] array = {{1,2,3,4},
                {2,3,4,5},
                {3,4,5,6}};

        int[][] transArray = transposition(array);

        for (int i=0;i<transArray.length;i++)
            for (int j=0;j<transArray[0].length;j++)
                System.out.println(transArray[i][j] + " ");
    }

    public static int[][] transposition(int[][] array){

        int[][] a = new int[array[0].length][array.length];

        for (int row=0;row<array.length;row++){
            for (int col=0;col<a.length;col++){
                a[col][row] = array[row][col];
            }
        }
        return a;
    }
}
