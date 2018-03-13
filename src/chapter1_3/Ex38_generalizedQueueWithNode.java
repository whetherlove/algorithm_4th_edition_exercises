package chapter1_3;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/30/030 14:01
 * @UpdateDate: 2018/1/30/030 14:01
 */
@SuppressWarnings("SameParameterValue")
class Ex38_generalizedQueueWithNode<Item> {

    private Node first;
    private int insertRank = 1;
    private class Node{
        final Item item;
        Node next;
        final int rank;
        Node(Item i, int r){
            item = i;
            rank = r;
        }
    }

    public boolean isEmpty(){
        return first == null;
    }

    void insert(Item item){
        if (first == null)
            first = new Node(item,insertRank++);
        else {
            Node current = first;
            while (current.next != null)
                current = current.next;
            current.next = new Node(item,insertRank++);
        }
    }

    void delete(int k){
        if (k>insertRank) throw new IndexOutOfBoundsException();
        if (first.rank == k) {
            Item item = first.item;
            first = first.next;
            return;
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
    }

    @Override
    public String toString() {
        if (first == null) return "";
        StringBuilder s = new StringBuilder();
        Node current = first;
        do {
            s.append(current.item.toString());
            current = current.next;
        }while (current != null);
        return s.toString();
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        Ex38_generalizedQueueWithNode<Integer> queue = new Ex38_generalizedQueueWithNode();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.delete(2);
        System.out.println(queue);
    }
}
