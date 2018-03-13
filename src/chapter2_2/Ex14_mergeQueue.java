package chapter2_2;

import edu.princeton.cs.algs4.Queue;

import static chapter2_2.Merge.less;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_2
 * @Description:
 * @date 25/02/2018 1:54 PM
 */
class Ex14_mergeQueue {

    @SuppressWarnings("unchecked")
    private static Queue merge(Queue<Comparable> a, Queue<Comparable> b){
        Queue r = new Queue();
        while (!(a.isEmpty() && b.isEmpty())){
            if (a.isEmpty())
                r.enqueue(b.dequeue());
            else if (b.isEmpty())
                r.enqueue(a.dequeue());
            else if (less(a.peek(),b.peek()))
                r.enqueue(a.dequeue());
            else
                r.enqueue(b.dequeue());
        }
        return r;
    }
    //Ex15
    @SuppressWarnings("unchecked")
    public static Queue<Comparable> merge(Queue<Comparable>[] a){
        Queue<Queue<Comparable>> r = new Queue();
        for (Queue<Comparable> q : a)
            r.enqueue(q);
        while (r.size() > 1){
            r.enqueue(merge(r.dequeue(),r.dequeue()));
        }
        return r.dequeue();
    }

    public static void main(String[] args) {
        Queue<Comparable> a = new Queue<>();
        Queue<Comparable> b = new Queue<>();
        a.enqueue("E");
        a.enqueue("J");
        b.enqueue("C");
        b.enqueue("B");
        System.out.println(merge(a,b));

    }
}
