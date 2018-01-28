package chapter1_3;

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

    public static Ex12_iterableStack copy(Ex12_iterableStack<String> s){
        Iterator<String> it = s.iterator();
        Ex12_iterableStack<String> result = new Ex12_iterableStack<>();
        Ex12_iterableStack<String> temp = new Ex12_iterableStack<>();
        while (it.hasNext()) {
            temp.push(it.next());
        }
        it = temp.iterator();
        while (it.hasNext()) {
            result.push(it.next());
        }
        return result;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            @Override
            public boolean hasNext() {
                return N > 0;
            }

            @Override
            public Item next() {
                return pop();
            }
        };
    }

}
