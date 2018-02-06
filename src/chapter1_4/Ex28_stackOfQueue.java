package chapter1_4;

import edu.princeton.cs.algs4.Queue;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_4
 * @Description:
 * @date 5/02/2018 9:09 PM
 */
public class Ex28_stackOfQueue<Item> {

    private Queue<Item> queue = new Queue<>();

    public void push(Item item){
        queue.enqueue(item);
    }

    public Item pop(){
        for (int i=0;i<queue.size()-1;i++)
            queue.enqueue(queue.dequeue());
        return queue.dequeue();
    }

    public static void main(String[] args) {
        Ex28_stackOfQueue<Integer> stack = new Ex28_stackOfQueue<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
