package chapter1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/23/023 15:30
 * @UpdateDate: 2018/1/23/023 15:30
 */
public class Ex11_print2DBoolArray {

    public static void main(String[] args) {

        boolean[][] boolArray = {{true,false,false},{false,true,false}};

        for (int row=0;row<boolArray.length;row++){
            for (int col=0;col<boolArray[0].length;col++){
                StdOut.println("row"+(row+1)+" col"+(col+1)+":"+boolArray[row][col]);
            }
        }
    }
}
