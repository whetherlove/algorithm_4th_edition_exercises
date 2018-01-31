package chapter1_3;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/28/028 15:05
 * @UpdateDate: 2018/1/28/028 15:05
 */
public class Ex12_iterableStack<Item> implements Iterable<Item>{

    private Node first;
    private int N;
    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
    //Ex50
    @Override
    public Iterator<Item> iterator() {
        return new StackItr();
    }

    private class StackItr implements Iterator{
        private int size = N;
        private Node current = first;

        @Override
        public boolean hasNext() {
            if (size != N) throw new ConcurrentModificationException();
            return size > 0;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new IndexOutOfBoundsException();
            Item item = current.next.item;
            current = current.next;
            size--;
            if (size != N) throw new ConcurrentModificationException();
            return item;
        }
    }

    public static void main(String[] args) {
        //test Ex50
        Ex12_iterableStack<Integer> stack = new Ex12_iterableStack<>();
        stack.push(1);
        stack.push(1);
        stack.push(1);

        Iterator it = stack.iterator();
        while (it.hasNext())
            stack.push(2);
    }
}
