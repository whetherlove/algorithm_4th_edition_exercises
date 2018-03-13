package chapter2_4;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_4
 * @Description:
 * @date 6/03/2018 7:20 PM
 */
@SuppressWarnings("ConstantConditions")
class Ex3_LinkedList<Item extends Comparable<Item>> {

    private final LinkedList<Item> pq = new LinkedList<>();

    private void insert(Item v){
        pq.add(v);
    }

    private Item max(){
        return pq.stream().max(Comparator.naturalOrder()).get();
    }

    private Item delMax() {
        Item max = max();
        //最大值有多个要求只删除一个，不能直接使用remove
        for (int i = 0; i < pq.size(); i++) {
            if (pq.get(i) == max) {
                pq.remove(i);
                break;
            }
        }
        return max;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Ex3_LinkedList pq = new Ex3_LinkedList();
        pq.insert(2);
        pq.insert(1);
        pq.insert(4);
        pq.insert(3);
        System.out.println(pq.max());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
    }
}
