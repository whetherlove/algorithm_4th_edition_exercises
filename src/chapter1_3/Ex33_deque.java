package chapter1_3;

import java.util.NoSuchElementException;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/29/029 10:36
 * @UpdateDate: 2018/1/29/029 10:36
 */
@SuppressWarnings("Duplicates")
class Ex33_deque<Item> {

    private Node leftMost;
    private Node rightMost;
    private int N = 0;
    private class Node{
        final Item item;
        Node left;
        Node right;
        Node(Item i){
            item = i;
        }
    }

    public boolean ismpty(){
        return N == 0;
    }

    int size(){
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
            leftMost = leftMost.right;
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
            leftMost = rightMost.left;
            N--;
            return item;
        }
    }

    @SuppressWarnings("unchecked")
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
