package chapter1_3;

import java.util.Iterator;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/28/028 19:00
 * @UpdateDate: 2018/1/28/028 19:00
 */
public class Ex29_circularLinkedList<Item> implements Iterable<Item>{

    private Node last;
    private int size = 0;

    @Override
    public Iterator iterator() {
        return new queueItr();
    }

    private class queueItr implements Iterator{

        private Node current = last;
        @Override
        public boolean hasNext() {
            return last.next != null;
        }

        @Override
        public Node next() {
            current = current.next;
            return current;
        }
    }

    private class Node{
        Item item;
        Node next;
        Node(Item i){
            item = i;
        }
    }

    public void enqueue(Item item){
        Node n = new Node(item);
        if (last == null){
            last = n;
            last.next = n;
        }
        else {
            n.next = last.next;
            last.next = n;
        }
        size++;
    }

    public Item dequeue(){
        if (isEmpty()) return null;
        Item item = last.next.item;
        if (last.next == last) last = null;
        else {
            Node temp = last.next.next;
            last.next = null;
            last.next = temp;
        }
        return item;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }
}
