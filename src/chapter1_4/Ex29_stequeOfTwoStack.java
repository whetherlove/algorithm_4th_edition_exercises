package chapter1_4;

import edu.princeton.cs.algs4.Stack;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_4
 * @Description:
 * @date 5/02/2018 9:20 PM
 */
@SuppressWarnings("SameParameterValue")
class Ex29_stequeOfTwoStack<Item> {

    private final Stack<Item> stack1 = new Stack<>();
    private final Stack<Item> stack2 = new Stack<>();

    void push(Item item){
        stack1.push(item);
    }

    Item pop(){
        return stack1.pop();
    }

    void enqueue(Item item){
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
        stack2.push(item);
        while (!stack2.isEmpty())
            stack1.push(stack2.pop());
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //test
        Ex29_stequeOfTwoStack<Integer> steque = new Ex29_stequeOfTwoStack();
        steque.push(1);
        steque.push(2);
        steque.enqueue(3);
        System.out.println(steque.pop());
        System.out.println(steque.pop());
        System.out.println(steque.pop());
    }
}
