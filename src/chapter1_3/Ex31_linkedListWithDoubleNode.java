package chapter1_3;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/29/029 8:31
 * @UpdateDate: 2018/1/29/029 8:31
 */
class Ex31_linkedListWithDoubleNode<Item> {

    private DoubleNode first;
    private int N = 0;
    private static class DoubleNode<Item>{
        Item item;
        DoubleNode previous;
        DoubleNode next;
    }

    void insertFirst(DoubleNode n){
        if (N == 0) first = n;
        else {
            n.next = first;
            first = n;
        }
        N++;
    }

    void insertLast(DoubleNode n){
        if (N == 0) first = n;
        else {
            DoubleNode current = first;
            while (current.next != null)
                current = current.next;
            current.next = n;
            n.previous = current;
        }
        N++;
    }

    private void deleteFirst(){
        if (N == 1) first = null;
        else {
            first.next.previous = null;
            first = first.next;
        }
        N--;
    }

    private void deleteLast(){
        if (N == 1) first = null;
        else if (N == 2) {
            first.next.previous = null;
            first.next = null;
        }
        else {
            DoubleNode current = first;
            while (current.next != null)
                current = current.next;
            current.next.previous = null;
            current.next = null;
        }
        N--;
    }
    //默认t存在于该链表中,n为将要添加的节点
    void insertBefore(DoubleNode t, DoubleNode n){
        if (first == t){
            n.next = t;
            t.previous = n;
            first = n;
        }
        else {
            n.previous = t.previous;
            t.previous.next = n;
            t.previous = n;
            n.next = t;
        }
        N++;
    }
    //默认t存在于该链表中,n为将要添加的节点
    public void insertAfter(DoubleNode t, DoubleNode n){
        if (t.next == null){
            t.next = n;
            n.previous = t;
        }
        else {
            n.next = t.next;
            t.next.previous = n;
            n.previous = t;
            t.next = n;
        }
        N++;
    }
    //默认n存在于该链表中
    void delete(DoubleNode n){
        if (N == 1) first = null;
        else if (n.previous == null)
            deleteFirst();
        else if (n.next == null)
            deleteLast();
        else {
            n.previous.next = n.next;
            n.next.previous = n.previous;
            n = null;
        }
        N--;
    }

    int size(){
        return N;
    }

    public static void main(String[] args) {

        Ex31_linkedListWithDoubleNode<Integer> list = new Ex31_linkedListWithDoubleNode<>();
        //test insertFirst
        DoubleNode<Integer> first = new DoubleNode<>();
        first.item = 1;
        list.insertFirst(first);
        System.out.println(list.size());
        System.out.println(list.first.next);
        //test insertLast
        DoubleNode<Integer> last = new DoubleNode<>();
        last.item = 2;
        list.insertLast(new DoubleNode());
        System.out.println(list.size());
        System.out.println(list.first.next);
        //test insertBefore
        DoubleNode<Integer> nb = new DoubleNode<>();
        nb.item = 5;
        list.insertBefore(first,nb);
        System.out.println(list.size());
        System.out.println(list.first.item);
        //test delete
        list.delete(first);
        System.out.println(list.size());
    }
}
