package chapter1_3;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/29/029 12:58
 * @UpdateDate: 2018/1/29/029 12:58
 */
class Ex35_randomQueue<Item> extends Ex34_randomBag<Item>{

    void enqueue(Item item){
        add(item);
    }

    Item dequeue(){
        if (size == 0) throw new NullPointerException();
        if (size == 1){
            Item item = items[0];
            items[0] = null;
            size--;
            return item;
        }
        int rand = StdRandom.uniform(size-1);
        Item item = items[rand];
        items[rand] = items[size-1];
        items[size-1] = null;
        size--;
        return item;
    }

    Item sample(){
        if (size == 0) throw new NullPointerException();
        return items[StdRandom.uniform(size-1)];
    }

    public static void main(String[] args) {
        //test
        Ex35_randomQueue<Integer> queue = new Ex35_randomQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.size());
        System.out.println(queue.sample());
        System.out.println(queue.sample());
        System.out.println(queue.dequeue());
        System.out.println(queue.size());

        //iteration
        for (Object aQueue : queue) System.out.println(aQueue);
    }
}


