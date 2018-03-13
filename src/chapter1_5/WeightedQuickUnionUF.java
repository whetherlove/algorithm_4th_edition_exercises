package chapter1_5;

import java.util.Arrays;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_5
 * @Description:
 * @date 6/02/2018 5:32 PM
 */
class WeightedQuickUnionUF {

    private final int[] id;
    private final int[] sz;
    private int count;
    private int times;

    //Ex20 动态生长
    //此题即使用
    //private int[] id = new int[1];
    //private int[] sz = new int[1];
    //来替代原数组
    //然后调用resize方法动态调整数组长度即可

    private WeightedQuickUnionUF(int N){
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
    //Ex12 路径压缩的quick-union算法
    private int find(int p){
        int root = p;
        while (root != id[root]) {
            root = id[root];
            times++;
        }
        while (p != id[p]){
            int oldP = p;
            id[oldP] = root;
            p = id[p];
        }
        return root;
    }

    private void union(int p, int q){
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        if (sz[i] < sz[j]){
            id[i] = j;
            sz[j] += sz[i];
        }else {
            id[j] = i;
            sz[i] += sz[j];
        }
        times ++;
        count--;
    }

    public static void main(String[] args) {
        int [][] input = {{9,0},{3,4},{5,8},{7,2},{2,1},{5,7},{0,3},{4,2}};
        int N = 10;
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        System.out.println(Arrays.toString(uf.id));
        for (int[] anInput : input) {
            //每次调用union，必调用2次find,若pRoot != qRoot, 则额外访问数组id1次,sz1次
            //每次调用find，访问数组次数为p到其根节点的深度
            int p = anInput[0];
            int q = anInput[1];
            uf.union(p, q);
            System.out.print(Arrays.toString(uf.id));
            System.out.print("\t" + Arrays.toString(uf.sz));
            System.out.println("\t" + uf.times);
        }
        //Ex12 {{0，1}，{1，2}，{2，3}，{3，4}}
        // result      0
        //        1  2  3  4
        //Ex13 加权 quick-union 中，两个大小相等的树合并可以有效增加高度，同时输入必须保证是根节点以规避路径压缩。
        //例子可见P146 图1.5.8最坏情况下的输入
        //
        //Ex14 使用int[] height 代替 int[] size
        //当两个高度相同的树合并时，任选一树作为主树，主树高度加1，副树不变
        //当两个高度不同的树合并时，高度较高的树为主树，主副树高度不变
    }
}
