package chapter1_4;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_4
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/2/3/003 15:45
 * @UpdateDate: 2018/2/3/003 15:45
 */
class Ex19_localMin2d {

    public static void main(String[] args) {

        //此题为Ex18扩展，依旧采取Ex18思路
        //以下二维数组有且仅有一个局部最小值 a[4][5] = 0
        int a[][] = {
                {1, 2, 3, 4, 5, 6, 7},
                {2, 3, 4, 5, 6, 7, 8},
                {3, 4, 5, 6, 7, 8, 9},
                {4, 5, 6, 7, 8, 9, 0},
                {5, 6, 7, 8, 9, 0, 1},
                {6, 7, 8, 9, 0, 1, 2},
                {7, 8, 9, 0, 1, 2, 3}
        };

        System.out.println(localMin(a));
    }

    private static int localMin(int[][] a){
        int rowLo = 0;
        int rowHi = a.length - 1;
        int colLo = 0;
        int colHi = a.length - 1;
        return localMin(a,rowLo,rowHi,colLo,colHi);
    }
    private static int localMin(int[][] a, int rowLo, int rowHi, int colLo, int colHi) {
        int rowMid = (rowHi - rowLo) / 2 + rowLo;
        int colMid = (colHi - colLo) / 2 + colLo;
        if (rowMid == rowLo || rowMid == rowHi || colMid == colLo || colMid == colHi)
            return Integer.MAX_VALUE;
        else if (a[rowMid][colMid] < a[rowMid][colMid - 1] &&
                 a[rowMid][colMid] < a[rowMid][colMid + 1] &&
                 a[rowMid][colMid] < a[rowMid - 1][colMid] &&
                 a[rowMid][colMid] < a[rowMid + 1][colMid])
            return a[rowMid][colMid];
        else if (localMin(a,rowLo,rowMid,colLo,colHi) != Integer.MAX_VALUE)
            return localMin(a,rowLo,rowMid,colLo,colHi);
        else if (localMin(a,rowMid,rowHi,colLo,colHi) != Integer.MAX_VALUE)
            return localMin(a,rowMid,rowHi,colLo,colHi);
        else if (localMin(a,rowLo,rowHi,colMid,colHi) != Integer.MAX_VALUE)
            return localMin(a,rowLo,rowHi,colMid,colHi);
        else
            return localMin(a,rowLo,rowHi,colLo,colMid);
    }
}
