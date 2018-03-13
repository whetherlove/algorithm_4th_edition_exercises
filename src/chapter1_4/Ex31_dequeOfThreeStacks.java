package chapter1_4;

import edu.princeton.cs.algs4.Stack;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_4
 * @Description:
 * @date 6/02/2018 9:36 AM
 */
class Ex31_dequeOfThreeStacks<Item> {

    private final Stack<Item> stack1 = new Stack<>();
    private final Stack<Item> stack2 = new Stack<>();
    private final Stack<Item> stack3 = new Stack<>();

    void pushLeft(Item item){
        stack1.push(item);
    }

    void pushRight(Item item){
        stack2.push(item);
    }

    Item popLeft(){
        if (!stack1.isEmpty())
            return stack1.pop();
        return pop(stack2);
    }

    Item popRight(){
        if (!stack2.isEmpty())
            return stack2.pop();
        return pop(stack1);
    }

    private Item pop(Stack<Item> stack){
        while (!stack.isEmpty())
            stack3.push(stack.pop());
        Item item = stack3.pop();
        while (!stack3.isEmpty())
            stack.push(stack3.pop());
        return item;
    }

    public static void main(String[] args) {
        Ex31_dequeOfThreeStacks<Integer> deque = new Ex31_dequeOfThreeStacks<>();
        deque.pushLeft(1);
        deque.pushLeft(2);
        deque.pushLeft(3);
        deque.pushRight(4);
        deque.pushRight(5);
        deque.pushRight(6);
        System.out.println(deque.popLeft());
        System.out.println(deque.popLeft());
        System.out.println(deque.popLeft());
        System.out.println(deque.popLeft());
        System.out.println(deque.popRight());

    }
}
