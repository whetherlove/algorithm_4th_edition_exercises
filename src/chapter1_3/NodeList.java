package chapter1_3;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/30/030 14:47
 * @UpdateDate: 2018/1/30/030 14:47
 */
public abstract class NodeList<Item> {

     Node first;

     class Node{
         Item item;
         Node next;
         Node(Item i){
             item = i;
         }
     }

     public boolean isEmpty(){
         return first == null;
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
}
