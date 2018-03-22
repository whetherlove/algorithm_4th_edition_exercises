package chapter2_5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_5
 * @Description:
 * @date 21/03/2018 5:43 PM
 */
public class Ex27_indirectSort {

    private static class Index{
        private int index;
        private Comparable c;

        public Index(int index, Comparable c) {
            this.index = index;
            this.c = c;
        }

        @Override
        public String toString() {
            return "" + index;
        }
    }

    public static Index[] indirectSort(Comparable[] a){
        Index[] indices = new Index[a.length];
        for (int i = 0; i < a.length; i++)
            indices[i] = new Index(i,a[i]);
        Arrays.sort(indices, (e1,e2) -> e1.c.compareTo(e2.c));
        return indices;
    }

    public static void main(String[] args) {
        Comparable[] a = {3,1,2,4,5};
        System.out.println(Arrays.toString(indirectSort(a)));
    }
}
