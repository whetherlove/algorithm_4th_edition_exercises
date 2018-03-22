package chapter2_5;

import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdRandom;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_5
 * @Description:
 * @date 13/03/2018 4:34 PM
 */
public class Ex17_checkStability {

    private static class Entry implements Comparable{
        private int key;
        private int value;

        public Entry(int key) {
            this.key = key;
            value = StdRandom.uniform(100);
        }

        @Override
        public int compareTo(Object o) {
            return value - ((Entry)o).value;
        }
    }

    public static boolean check(Method sort) throws InvocationTargetException, IllegalAccessException {
        //生成随机Entry数组,key为元素顺序，value为随机数，对value进行排序
        Entry[] entries = new Entry[1000];
        for (int i = 0; i < 1000; i++) {
            entries[i] = new Entry(i);
        }
        sort.invoke(null,(Object) entries);
        //check relative position
        for (int i = 1; i < 1000; i++)
            if (entries[i].value == entries[i-1].value &&
                    entries[i].key < entries[i-1].key)
                return false;
        return true;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //检测Arrays.sort()是否稳定，根据官方API，该算法为优化过的快速排序，具有稳定性
        Method m = Arrays.class.getMethod("sort", Object[].class);
        System.out.println(check(m));
        //检测Quick.sort()是否稳定,该算法为标准快速排序，不具有稳定性
        Method m1 = Quick.class.getMethod("sort", Comparable[].class);
        System.out.println(check(m1));
    }
}
