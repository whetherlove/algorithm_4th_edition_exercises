package chapter1_5;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_5
 * @Description:
 * @date 6/02/2018 4:44 PM
 */
public class QuickFindUF {

    private int[] id;
    private int count;
    private int times = 0;

    public QuickFindUF(int N){
        count = N;
        id = new int[N];
        for (int i=0;i<N;i++)
            id[i] = i;
    }

    public int count(){
        return count;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int find(int p){
        times++;
        return id[p];
    }

    public void union(int p, int q){
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) return;
        for (int i = 0; i < id.length; i++) {
            times++;
            if (id[i] == pID)
                id[i] = qID;
        }
        count--;
    }

    public static void main(String[] args) {
        int [][] input = {{9,0},{3,4},{5,8},{7,2},{2,1},{5,7},{0,3},{4,2}};
        int N = 10;
        QuickFindUF uf = new QuickFindUF(N);
        HashMap<Integer,Integer> points = new HashMap<>();
        System.out.println(Arrays.toString(uf.id));
        for (int i = 0; i < input.length; i++) {
            //每次调用union，必调用2次find,若pID != qID, 则额外访问数组N次
            //每次调用find，访问数组次数为1
            int p = input[i][0];
            int q = input[i][1];
            uf.union(p,q);
            System.out.print(Arrays.toString(uf.id));
            System.out.println("\t" + uf.times);
        }
        //Ex8 若输入为以下，当最后一个对整数输入前
        // id = {0,0,0,0,6,6,6,6}
        //输入{0，8}后，首先由于id[0] = 0, id[0]将会变为6
        //如此，由于id[1]到id[3] 均不等于6，将不会被改变
        //int[][] input2 = {{1,0},{2,0},{3,0},{4,0},{5,6},{7,6},{8,6},{0,6}};

    }

}
