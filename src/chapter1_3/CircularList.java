package chapter1_3;

import java.util.Iterator;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/29/029 16:50
 * @UpdateDate: 2018/1/29/029 16:50
 */
public class CircularList<Item> {

    private Node last;
    private Node first;
    private Node current;
    private class Node{
        Item item;
        Node next;
        Node(Item i){
            item = i;
        }
        public String toString(){
            return item.toString();
        }
    }

    public void add(Item item){
        Node n = new Node(item);
        if (first == null){
            last = n;
            first = n;
            last.next = first;
            first.next = last;
            current = last;
        }
        else {
            last.next = n;
            n.next = first;
            last = n;
        }
    }

    public void passCurrentBy(int m){
        for (int i=1;i<m;i++)
            current = current.next;
    }

    public Item getCurrent(){
        if (first == null) throw new NullPointerException();
        Item item = current.item;
        if (first == last) {
            first = null;
            last = null;
            return item;
        }
        if (current == first){
            first = current.next;
            last.next = first;
            current = first;
        }else {
            Node preNode = first;
            while (preNode.next != current)
                preNode = preNode.next;
            if (current == last){
                last = preNode;
                last.next = first;
                current = first;
            }else{
                preNode.next = current.next;
                current = current.next;
            }
        }

        return item;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        if (first == null) return 0;
        Node head = first;
        int count = 1;
        while (head.next != first){
            head = head.next;
            count++;
        }
        return count;
    }

    public String toString(){
        if (first == null) return null;
        Node current = first;
        String string = "";
        do {
            string += current.toString();
            current = current.next;
        }while (current != first);
        return string;
    }
}
