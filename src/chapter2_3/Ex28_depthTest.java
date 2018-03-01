package chapter2_3;

import com.sun.source.tree.BinaryTree;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdRandom;

import static chapter2_3.Quick.partition;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_3
 * @Description:
 * @date 1/03/2018 4:01 PM
 */
public class Ex28_depthTest {

    private static int M;
    //TODO
    //使用二叉树记录递归，递归深度即二叉树高度

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a); // 消除对输入的依赖
        sort(a, 0, a.length - 1);
        Insertion.sort(a);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi - lo <= M){
            Insertion.sort(a,lo,hi);
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }
}
