package chapter1_3;

import java.util.NoSuchElementException;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/30/030 14:50
 * @UpdateDate: 2018/1/30/030 14:50
 */
class Ex41_copyQueue<Item> extends NodeList<Item>{

    private Ex41_copyQueue(){}
    private Ex41_copyQueue(Ex41_copyQueue<Item> queue){
        if (queue.first == null) return;
        this.first = new Node(queue.first.item);
        Node current = this.first;
        Node queueCurrent = queue.first;
        while (queueCurrent.next != null){
            current.next = new Node(queueCurrent.next.item);
            current = current.next;
            queueCurrent = queueCurrent.next;
        }
    }

    void enqueue(Item item){
        if (first == null)
            first = new Node(item);
        else {
            Node current = first;
            while (current.next != null)
                current = current.next;
            current.next = new Node(item);
        }
    }

    void dequeue(){
        if (first == null) throw new NoSuchElementException();
        if (first.next == null){
            Item item = first.item;
            first = null;
            return;
        }
        Item item = first.item;
        first = first.next;
    }

    //Ex47
    @SuppressWarnings("unchecked")
    void catenation(Ex41_copyQueue q){
        if (this.first == null) return;
        if (q.first == null) return;
        if (this.first.next == null){
            this.first.next = q.first;
        }
        else {
            Node current = this.first;
            while (current.next != null)
                current = current.next;
            current.next = q.first;
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //test
        Ex41_copyQueue<Integer> queue = new Ex41_copyQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        Ex41_copyQueue<Integer> anotherQueue = new Ex41_copyQueue<>(queue);
        System.out.println(anotherQueue);
        anotherQueue.dequeue();
        System.out.println(queue);
        System.out.println(anotherQueue);
        //test Ex47 catenation
        queue.catenation(anotherQueue);
        System.out.println(queue);
    }
}
