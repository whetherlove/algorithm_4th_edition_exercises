package chapter2_5;

import edu.princeton.cs.algs4.Quick;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static chapter2_5.Ex17_checkStability.check;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_5
 * @Description:
 * @date 13/03/2018 4:36 PM
 */
public class Ex18_forcedStability {

    private static class Entry implements Comparable{
        private int key;
        private Comparable value;

        public Entry(int key, Comparable value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Object o) {
            return value.compareTo(((Entry)o).value);
        }
    }

    public static boolean stableSort(Comparable[] a, Method sort) throws InvocationTargetException, IllegalAccessException {
        //create new Entry arrays
        Entry[] entries = new Entry[a.length];
        for (int i = 0; i < a.length; i++)
            entries[i] = new Entry(i,a[i]);
        //sort entries using the given method
        sort.invoke(null,(Object) a);
        //rearrange the entries
        for (int i = 1; i < entries.length; i++) {
            int current = i;
            while (current > 0 &&
                    entries[current].value.equals(entries[current-1].value) &&
                    entries[current].key < entries[current-1].key){
                Entry temp = entries[current];
                entries[current] = entries[current-1];
                entries[current-1] = temp;
                current--;
            }
        }
        //check if the rearrange works
        for (int i = 1; i < entries.length; i++)
            if (entries[i].value == entries[i-1].value &&
                    entries[i].key < entries[i-1].key)
                return false;
        return true;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //Quick中的标准快排是不稳定的，经过强制稳定，结果应返回true
        Method m = Quick.class.getMethod("sort", Comparable[].class);
        System.out.println(check(m));
        Comparable[] a = {4,4,5,1,2,1,6};
        System.out.println(stableSort(a,m));

    }
}
