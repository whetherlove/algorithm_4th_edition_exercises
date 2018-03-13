package chapter1_3;

import java.util.Iterator;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/28/028 10:25
 * @UpdateDate: 2018/1/28/028 10:25
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {

    //使用泛型Item
    @SuppressWarnings("unchecked")
    Item[] a = (Item[]) new Object[1]; // stack entries
    int N = 0; // size

    public boolean isEmpty() {
        return N == 0;
    }

    int size() {
        return N;
    }

    //动态调整数组大小
    @SuppressWarnings("unchecked")
    void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        System.arraycopy(a, 0, temp, 0, N);
        a = temp;
    }

    public void push(Item item) {
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N++] = item;
    }

    Item pop() {
        Item item = a[--N];
        //将弹出的对象设为null,避免对象游离
        a[N] = null;
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {
        }
    }
}
