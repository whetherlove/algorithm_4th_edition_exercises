package chapter1_3;

import java.util.*;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/29/029 11:32
 * @UpdateDate: 2018/1/29/029 11:32
 */
public class Ex34_randomBag<Item> implements Iterable<Item>{

    protected int size = 0;
    protected Item[] items = (Item[]) new Object[1];

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void add(Item item){
        if (size == items.length) {
            resize(2 * items.length);
        }
        items[size++] = item;
    }

    public void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < size; i++)
            temp[i] = items[i];
        items = temp;
    }


    @Override
    public Iterator<Item> iterator() {
        return new bagItr();
    }

    private class bagItr implements Iterator<Item>{
        private int N = size;
        private Item[] a = items;
        @Override
        public boolean hasNext() {
            return N-- != 0;
        }
        //通过让next方法每次返回随机元素来实现随机背包
        @Override
        public Item next() {
            if (isEmpty()) throw new NoSuchElementException();
            shuffle(a);
            return a[N];
        }

        private void shuffle(Item[] a){
            ArrayList<Item> temp = new ArrayList<>();
            for (int i=0;i<N;i++)
                temp.add(a[i]);
            Collections.shuffle(temp);
            for (int i=0;i<N;i++)
                a[i] = temp.get(i);
        }
    }

    public static void main(String[] args) {
        Ex34_randomBag<Integer> bag = new Ex34_randomBag();
        for (int i=0;i<10;i++)
            bag.add(i);
        System.out.println(bag.size());
        Iterator it = bag.iterator();
        while (it.hasNext())
            System.out.println(it.next());
        System.out.println(bag.size());
    }
}
