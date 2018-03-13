package chapter1_4;

import chapter1_3.Ex32_steque;
import edu.princeton.cs.algs4.Stack;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_4
 * @Description:
 * @date 5/02/2018 9:56 PM
 */
class Ex30_dequeOfStackAndSteque<Item> {

    @SuppressWarnings("unchecked")
    private final Stack<Item> stack = new Stack();
    @SuppressWarnings("unchecked")
    private final Ex32_steque<Item> steque = new Ex32_steque();

    void pushLeft(Item item){
        steque.push(item);
    }

    Item popLeft(){
        return steque.pop();
    }

    void pushRight(Item item){
        steque.enqueue(item);
    }

    Item popRight(){
        while (!steque.isEmpty())
            stack.push(steque.pop());
        Item item = stack.pop();
        while (!stack.isEmpty())
            steque.push(stack.pop());
        return item;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Ex30_dequeOfStackAndSteque<Integer> deque = new Ex30_dequeOfStackAndSteque();
        deque.pushLeft(1);
        deque.pushLeft(2);
        deque.pushRight(3);
        deque.pushRight(4);
        System.out.println(deque.popLeft());
        System.out.println(deque.popRight());
    }
}
