package chapter1_3;

import com.sun.scenario.effect.impl.prism.PrImage;

import java.util.NoSuchElementException;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/29/029 10:36
 * @UpdateDate: 2018/1/29/029 10:36
 */
public class Ex33_deque<Item> {

    private Node leftMost;
    private Node rightMost;
    private int N = 0;
    private class Node{
        Item item;
        Node left;
        Node right;
        Node(Item i){
            item = i;
        }
    }

    public boolean ismpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void pushLeft(Item item){
        Node n = new Node(item);
        if (N == 0){
            leftMost = n;
            rightMost = n;
        }
        else {
            n.right = leftMost;
            leftMost = n;
        }
        N++;
    }

    public void pushRight(Item item){
        Node n = new Node(item);
        if (N == 0){
            leftMost = n;
            rightMost = n;
        }
        else {
            n.left = rightMost;
            rightMost = n;
        }
        N++;
    }

    public Item popLeft(){
        if (N == 0) throw new NoSuchElementException();
        if (N == 1) {
            Item item = leftMost.item;
            leftMost = null;
            rightMost = null;
            N--;
            return item;
        }
        else {
            Item item = leftMost.item;
            Node temp = leftMost.right;
            leftMost = temp;
            N--;
            return item;
        }
    }

    public Item popRight(){
        if (N == 0) throw new NoSuchElementException();
        if (N == 1) {
            Item item = rightMost.item;
            leftMost = null;
            rightMost = null;
            N--;
            return item;
        }
        else {
            Item item = rightMost.item;
            Node temp = rightMost.left;
            leftMost = temp;
            N--;
            return item;
        }
    }

    public static void main(String[] args) {
        //test
        Ex33_deque<Integer> deque = new Ex33_deque();
        deque.pushLeft(1);
        System.out.println(deque.size());
        deque.pushRight(2);
        System.out.println(deque.size());
        System.out.println(deque.popLeft());
        System.out.println(deque.popRight());

    }
}
