package chapter2_5;

import java.util.ArrayList;


/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_5
 * @Description:
 * @date 21/03/2018 4:18 PM
 */
public class StableMinPQ<Item extends Comparable<Item>> {

    //堆实现的优先队列不稳定
    //此处使用ArrayList 和 插入排序 实现 稳定性

    private ArrayList<Item> pq = new ArrayList<>();

    private void insert(Item item){
       if (pq.size() == 0) {
           pq.add(item);
           return;
       }
       int pos = pq.size();
       while (pq.get(--pos).compareTo(item) > 0 && pos > 0);
       pq.add(pos+1,item);
    }

    private Item delMin(){
        Item item = pq.get(0);
        pq.remove(0);
        return item;
    }

    @Override
    public String toString() {
        return pq.toString();
    }

    public static void main(String[] args) {
        StableMinPQ<Integer> pq = new StableMinPQ<>();
        pq.insert(0);
        pq.insert(1);
        pq.insert(2);
        pq.insert(2);
        System.out.println(pq);
        System.out.println(pq.delMin());
        System.out.println(pq.delMin());
        System.out.println(pq.delMin());
    }
}
