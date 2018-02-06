package chapter1_3;

import java.util.NoSuchElementException;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/29/029 10:09
 * @UpdateDate: 2018/1/29/029 10:09
 */
public class Ex32_steque<Item> {

    private Node first;
    private Node last;
    private int N = 0;
    private class Node{
        Item item;
        Node next;
        Node(Item i){
            item = i;
        }
    }

    public void push(Item item){
        Node n = new Node(item);
        if (N == 0){
            first = n;
            last = n;
        }
        else {
            n.next = first;
            first = n;
        }
        N++;
    }

    public Item pop(){
        if (N == 0) throw new NoSuchElementException();
        else if (N == 1) {
            Item item = first.item;
            first = null;
            last = null;
            N--;
            return item;
        }
        else {
            Item item = first.item;
            first = first.next;
            N--;
            return item;
        }
    }

    public void enqueue(Item item){
        Node n = new Node(item);
        if (N == 0){
            first = n;
            last = n;
        }
        else {
            last.next = n;
            last = n;
        }
        N++;
    }

    public boolean isEmpty(){
        return N == 0;
    }
}
