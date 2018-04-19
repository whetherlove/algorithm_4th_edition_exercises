package chapter3_1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter3_1
 * @Description:
 * @date 29/03/2018 9:09 AM
 */
public class ArrayST<Key extends Comparable<Key>, Value> {

    private Key[] keys;

    private Value[] vals;

    private int N;

    private int capacity = 1;

    public ArrayST() {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    private boolean isEmpty() {
        return N == 0;
    }

    public void put(Key key, Value value){
        for (int i = 0; i < N; i++) {
            if (keys[i].compareTo(key) == 0) {
                vals[i] = value;
                return;
            }
        }
        keys[N] = key;
        vals[N] = value;
        N++;
        if (N == capacity) {
            capacity *= 2;
            resize(capacity);
        }
    }

    private void resize(int max) {
        keys = Arrays.copyOf(keys, max);
        vals = Arrays.copyOf(vals, max);
    }

//    public Value get(Key key) {
//        if (isEmpty())
//            return null;
//        for (int i = 0; i < N; i++) {
//            if (keys[i].compareTo(key) == 0)
//                return vals[i];
//        }
//        return null;
//    }

    //Ex 3.1.2
    public Value get(Key key) {
        if (isEmpty())
            return null;
        for (int i = 0; i < N; i++) {
            if (keys[i].compareTo(key) == 0) {
                moveToFront(i);
                return vals[0];
            }
        }
        return null;
    }

    private void moveToFront(int i) {
        Key key = keys[i];
        Value value = vals[i];
        for (int j = i; j > 0; j--) {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[0] = key;
        vals[0] = value;
    }

    public void delete(Key key){
        for (int i = 0; i < N; i++) {
            if (keys[i].compareTo(key) == 0){
                for (int j = i; j < N - 1 ; j++) {
                    keys[j] = keys[j+1];
                    vals[j] = vals[j+1];
                }
                N--;
                keys[N] = null;
                vals[N] = null;
            }
        }
    }

    public boolean contains(Key key){
        for (int i = 0; i < N; i++) {
            if (keys[i].compareTo(key) == 0)
                return true;
        }
        return false;
    }

    public Iterable<Key> keys(){
        return Arrays.asList(keys);
    }

}
