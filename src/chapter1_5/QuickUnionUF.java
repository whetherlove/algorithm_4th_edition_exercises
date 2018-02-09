package chapter1_5;

import java.util.Arrays;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_5
 * @Description:
 * @date 6/02/2018 5:56 PM
 */
public class QuickUnionUF {

    private int[] id;
    private int[] sz;
    private int count;
    private int times = 0;

    public QuickUnionUF(int N){
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int count(){
        return count;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int find(int p){
        while (p != id[p]) {
            p = id[p];
            times++;
        }
        return p;
    }

    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        times ++;
        count--;
    }

    public static void main(String[] args) {
        int [][] input = {{9,0},{3,4},{5,8},{7,2},{2,1},{5,7},{0,3},{4,2}};
        int N = 10;
        QuickUnionUF uf = new QuickUnionUF(N);
        System.out.println(Arrays.toString(uf.id));
        for (int i = 0; i < input.length; i++) {
            //每次调用union，必调用2次find,若pRoot != qRoot, 则额外访问数组1次
            //每次调用find，访问数组次数为p到其根节点的深度
            int p = input[i][0];
            int q = input[i][1];
            uf.union(p,q);
            System.out.print(Arrays.toString(uf.id));
            System.out.println("\t" + uf.times);
        }
    }
}
