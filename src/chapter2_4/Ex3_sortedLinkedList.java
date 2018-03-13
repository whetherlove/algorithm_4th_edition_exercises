package chapter2_4;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_4
 * @Description:
 * @date 6/03/2018 7:17 PM
 */
class Ex3_sortedLinkedList<Item extends Comparable<Item>> {

    private final LinkedList<Item> pq = new LinkedList<>();

    private void insert(Item v){
        pq.add(v);
        pq.sort(Comparator.reverseOrder());
    }

    private Item max(){
        return pq.get(0);
    }

    private Item delMax() {
        Item max = max();
        pq.remove(0);
        return max;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Ex3_sortedLinkedList pq = new Ex3_sortedLinkedList();
        pq.insert(2);
        pq.insert(1);
        pq.insert(4);
        pq.insert(3);
        System.out.println(pq.max());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
    }
}
