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
public class Ex30_dequeOfStackAndSteque<Item> {

    private Stack<Item> stack = new Stack();
    private Ex32_steque<Item> steque = new Ex32_steque();

    public void pushLeft(Item item){
        steque.push(item);
    }

    public Item popLeft(){
        return steque.pop();
    }

    public void pushRight(Item item){
        steque.enqueue(item);
    }

    public Item popRight(){
        while (!steque.isEmpty())
            stack.push(steque.pop());
        Item item = stack.pop();
        while (!stack.isEmpty())
            steque.push(stack.pop());
        return item;
    }

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
