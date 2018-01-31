package chapter1_3;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/30/030 14:01
 * @UpdateDate: 2018/1/30/030 14:01
 */
public class Ex38_generalizedQueueWithNode<Item> {

    private Node first;
    int insertRank = 1;
    private class Node{
        Item item;
        Node next;
        int rank;
        Node(Item i, int r){
            item = i;
            rank = r;
        }
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insert(Item item){
        if (first == null)
            first = new Node(item,insertRank++);
        else {
            Node current = first;
            while (current.next != null)
                current = current.next;
            current.next = new Node(item,insertRank++);
        }
    }

    public Item delete(int k){
        if (k>insertRank) throw new IndexOutOfBoundsException();
        if (first.rank == k) {
            Item item = first.item;
            first = first.next;
            return item;
        }
        Node current = first;
        while (current.next.rank != k)
            current = current.next;
        Item item = current.next.item;
        if (k == insertRank)
            current.next = null;
        else {
            current.next = current.next.next;
        }
        return current.item;
    }

    @Override
    public String toString() {
        if (first == null) return "";
        String s = "";
        Node current = first;
        do {
            s += current.item.toString();
            current = current.next;
        }while (current != null);
        return s;
    }

    public static void main(String[] args) {

        Ex38_generalizedQueueWithNode<Integer> queue = new Ex38_generalizedQueueWithNode();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.delete(2);
        System.out.println(queue);
    }
}
