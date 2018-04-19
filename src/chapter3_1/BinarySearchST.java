package chapter3_1;

import edu.princeton.cs.algs4.Queue;

import java.util.Arrays;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter3_1
 * @Description:
 * @date 28/03/2018 7:32 PM
 */
public class BinarySearchST<Key extends Comparable<Key>, Value>{

    private Key[] keys;

    private Value[] vals;
    //Ex25 使用一个数组记录访问频率，一个int储存最高访问频率，一个int储存当前访问最频繁的元素的位置
    private int[] frequencies;
    private int highestF;
    private int cache;

    private int N;

    private int capacity = 1;



    public BinarySearchST() {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
        frequencies = new int[capacity];
    }

    public int size() {
        return N;
    }

    public int size(Key lo, Key hi){
        return rank(hi) - rank(lo);
    }

    private boolean isEmpty() {
        return N == 0;
    }

    public Value get(Key key) {
        if (isEmpty())
            return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            frequencies[i]++;
            if (frequencies[i] > highestF) {
                highestF = frequencies[i];
                cache = i;
            }
            return vals[i];
        }
        else
            return null;
    }

    /**
     *
     * @param key
     * @return 返回比给定key小的元素的个数
     */
    private int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0)
                hi = mid - 1;
            else if (cmp > 0)
                lo = mid + 1;
            else
                return mid;
        }
        return lo;
    }

    public void put(Key key, Value value) {
        //Ex28
        if (key.compareTo(keys[N-1]) > 0){
            keys[N] = key;
            vals[N] = value;
            frequencies[N] = 0;
            N++;
        }
        else {
            int i = rank(key);
            // 若第i位于给定key相同，则进行修改
            if (i < N && keys[i].compareTo(key) == 0) {
                vals[i] = value;
                return;
            }
            // 若第i位于给定key不同，说明数组中未含有该key
            for (int j = N; j > i; j--) {
                keys[j] = keys[j - 1];
                vals[j] = vals[j - 1];
                frequencies[j] = frequencies[j - 1];
            }
            keys[i] = key;
            vals[i] = value;
            frequencies[i] = 0;
            N++;
        }
        if (N == capacity) {
            capacity *= 2;
            resize(capacity);
        }
        confirm();
    }

    private void confirm(){
        for (int i = 0; i < N; i++) {
            assert i == rank(select(i));
        }
        assert Arrays.stream(keys).sorted().toArray(Comparable[]::new).equals(keys);
    }

    private void resize(int max) {
        keys = Arrays.copyOf(keys, max);
        vals = Arrays.copyOf(vals, max);
        frequencies = Arrays.copyOf(frequencies,max);
    }

    public Key min() {
        if (N == 0) throw new ArrayIndexOutOfBoundsException();
        frequencies[0]++;
        if (frequencies[0] > highestF) {
            highestF = frequencies[0];
            cache = 0;
        }
        return keys[0];
    }

    public Key max() {
        if (N == 0) throw new ArrayIndexOutOfBoundsException();
        frequencies[N-1]++;
        if (frequencies[N-1] > highestF) {
            highestF = frequencies[N - 1];
            cache = N-1;
        }
        return keys[N - 1];
    }

    public Key select(int k) {
        if (k < 0 || k > N - 1) throw new ArrayIndexOutOfBoundsException();
        frequencies[k]++;
        if (frequencies[k] > highestF) {
            highestF = frequencies[N - 1];
            cache = N-1;
        }
        return keys[k];
    }

    /**
     *
     * @param key
     * @return 大于等于key的最小键
     */
    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    /**
     * Ex3.1.17
     * @param key
     * @return 小于等于key的最大键
     */
    public Key floor(Key key) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0)
            return key;
        return i == 0 ? null : keys[i - 1];
    }

    /**
     * Ex3.1.16
     * @param key
     * @return
     */
    public void delete(Key key){
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0){
            for (int j = i; j < N -1; j++) {
                keys[j] = keys[j+1];
                vals[j] = vals[j+1];
                frequencies[j] = frequencies[j+1];
            }
            N--;
            keys[N] = null;
            vals[N] = null;
            frequencies[N] = 0;

            if (N <= capacity/4){
                capacity /= 2;
                resize(capacity);
            }
        }
        confirm();
    }

    public Iterable<Key> keys(Key lo, Key hi){
        Queue<Key> q = new Queue<>();
        for (int i = rank(lo); i < rank(hi); i++)
            q.enqueue(keys[i]);
        if (contains(hi))
            q.enqueue(keys[rank(hi)]);
        return q;
    }

    public Iterable<Key> keys(){
        return keys(min(),max());
    }

    public boolean contains(Key key) {
        return keys[rank(key)].compareTo(key) == 0;
    }

}
