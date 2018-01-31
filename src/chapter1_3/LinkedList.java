package chapter1_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

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

    LinkedList(Node n){
        first = n;
        N = 1;
    }

    @Override
    public Iterator<Item> iterator(){
        return new ListItr();
    }

    private class ListItr implements Iterator{

        private LinkedList.Node current = first;

        @Override
        public boolean hasNext() {
            if (current == null) return false;
            return current.next != null;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            current = current.next;
            return (Item) current.item;
        }
    }

    private static class Node<Item>{
        Item item;
        Node next;
        Node(Item i){
            item = i;
        }
        @Override
        public String toString() {
            return this.item.toString();
        }
    }

    public void deleteFirst(){
        if (N == 0) throw new NoSuchElementException();
        if (N == 1) first = null;
        first = first.next;
        N--;
    }
    //Ex 1.3.19
    public void deleteLast(){
        if (N == 0) throw new NoSuchElementException();
        if (N == 1) first = null;
        if (N == 2){
            first.next = null;
        }
        else {
            Node current = first;
            while (current.next.next != null){
                current = current.next;
            }
            current.next = null;
        }
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
        N--;
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
        N--;
    }
    //Ex1.3.25
    public void insertAfter(Node t, Node n){
        n.next = null;
        if (t == null || n == null)
            throw new NoSuchElementException("Cannot find Node t");
        if (t.next == null){
            t.next = n;
        }
        else {
            n.next = t.next;
            t.next = n;
        }
        N++;
    }
    //Ex 1.3.26
    public static void remove(LinkedList l , String key){
        if (l.N == 0) return;
        while (l.first.item.equals(key)){
            if (l.N == 1)
                l.first = null;
            else
                l.first = l.first.next;
            l.N--;
        }
        Node current = l.first;
        while (current.next != null){
            if (current.next.item.equals(key)){
                if (current.next.next == null){
                    current.next = null;
                    l.N--;
                    return;
                }else {
                    current.next = current.next.next;
                }
                l.N--;
            }else
                current = current.next;
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
        if (first.next == null) return first.item;
        return Math.max(first.item,maxWithRecursion(first.next));
    }
    //Ex 1.3.30
    public static Node reverse(Node first){
        if (first.next == null) return first;
        Stack<Node> stack = new Stack<>();
        while (first.next != null){
            stack.push(first);
            first = first.next;
        }
        Node result = first;
        while (!stack.isEmpty()){
            Node next = stack.pop();
            first.next = next;
            first = next;
        }
        return result;
    }

    public String toString(){
        if (first == null) return null;
        Node current = first;
        String string = "";
        while (current != null){
            string += current.item;
            current = current.next;
        }
        return string;
    }

    public static void main(String[] args) {
        //test constructor
        Node first = new Node("1");
        LinkedList<String> list = new LinkedList<>(first);
        System.out.println("list=" + list + " size=" + list.N);
        Node second = new Node("2");
        list.insertAfter(first,second);
        System.out.println("list=" + list + " size=" + list.N);
        //test insert
        Node third = new Node("3");
        Node forth = new Node("4");
        Node fifth = new Node("5");
        list.insertAfter(second,third);
        System.out.println("list=" + list + " size=" + list.N);
        list.insertAfter(third,forth);
        System.out.println("list=" + list + " size=" + list.N);
        list.insertAfter(second,fifth);
        System.out.println("list=" + list + " size=" + list.N);
        //test find
        System.out.println(find(list,"4"));
        //test delete
        list.deleteLast();
        System.out.println("list=" + list + " size=" + list.N);
        list.deleteFirst();
        System.out.println("list=" + list + " size=" + list.N);
        list.delete(2);
        System.out.println("list=" + list + " size=" + list.N);
        //test remove
        Node anotherThird = new Node("3");
        list.insertAfter(third,anotherThird);
        System.out.println("list=" + list + " size=" + list.N);
        remove(list,"3");
        System.out.println("list=" + list + " size=" + list.N);
        list.insertAfter(second,third);
        list.insertAfter(third,forth);
        list.insertAfter(forth,fifth);
        System.out.println("list=" + list + " size=" + list.N);
        list.removeAfter(third);
        System.out.println("list=" + list + " size=" + list.N);
        //test reverse
        System.out.println(reverse(second).item);
        //test max
        Node<Integer> a = new Node<>(1);
        Node<Integer> b = new Node<>(3);
        Node<Integer> c = new Node<>(16);
        Node<Integer> d = new Node<>(2);
        Node<Integer> e = new Node<>(8);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        System.out.println(max(a));
        System.out.println(maxWithRecursion(a));
    }
}
