package chapter1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/28/028 16:21
 * @UpdateDate: 2018/1/28/028 16:21
 */
public class LinkedList<Item> implements Iterable<Item>{

    private Node first;
    private int N = 0;

    @Override
    public Iterator<Item> iterator(){
        return new ListItr();
    }

    private class ListItr implements Iterator{

        private LinkedList.Node current;

        @Override
        public boolean hasNext() {
            if (current == null) return false;
            return current.next != null;
        }

        @Override
        public LinkedList.Node next() {
            if (!hasNext())
                throw new NoSuchElementException();
            current = current.next;
            return current;
        }
    }

    private static class Node<Item>{
        Item item;
        Node next;
    }

    public void deleteFirst(){
        if (N == 0) throw new NoSuchElementException();
        if (N == 1) first = null;
        first = first.next;
    }
    //Ex 1.3.19
    public void deleteLast(){
        if (N == 0) throw new NoSuchElementException();
        if (N == 1) first = null;
        Node current = first;
        while (current.next != null){
            current = current.next;
        }
        current.next = null;
        N--;
    }
    //Ex 1.3.20
    public void delete(int k){
        if (k < 0 || k > N)
            throw new NoSuchElementException();
        if (k == N)
            deleteLast();
        Node current = first;
        if (k == 1)
            deleteFirst();
        for (int i=1;i<k-1;i++)
            current = current.next;
        Node temp = current.next;
        current.next = null;
        current.next = temp.next;
    }
    public void delete(Node n){
        if (n == null || N == 0) throw new NoSuchElementException();
        if (n.next == null) deleteLast();
        Node current = first;
        while (current.next != n && current.next != null)
            current = current.next;
        if (current.next == n){
            current.next = n.next;
            n.next = null;
        }
    }
    //Ex 1.3.21
    public static boolean find(LinkedList l , String key){
        Iterator it = l.iterator();
        while (it.hasNext()){
            if (it.next().equals(key))
                return true;
        }
        return false;
    }
    //Ex1.3.24
    public void removeAfter(Node n){
        if (n == null || n.next == null)
            throw new NoSuchElementException();
        Node temp = n.next;
        n.next = null;
        n.next = temp.next;
    }
    //Ex1.3.25
    public void insertAfter(Node t, Node n){
        if (t == null || n == null)
            throw new NoSuchElementException();
        t.next.next = n.next;
        t.next = n;
    }
    //Ex 1.3.26
    public static void remove(LinkedList l , String key){
        Iterator it = l.iterator();
        while (it.hasNext()) {
            Node n = (Node) it.next();
            if (n.item.equals(key))
                l.delete(n);
        }
    }
    //Ex 1.3.27
    public static int max(Node<Integer> first){
        int max = first.item;
        while (first.next != null){
            first = first.next;
            if (first.item > max)
                max = first.item;
        }
        return max;
    }
    //Ex 1.3.28
    public static int maxWithRecursion(Node<Integer> first){
        return Math.max(first.item,maxWithRecursion(first.next));
    }
}
