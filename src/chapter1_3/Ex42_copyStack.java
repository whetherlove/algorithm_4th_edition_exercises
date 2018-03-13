package chapter1_3;

import java.util.NoSuchElementException;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/30/030 15:08
 * @UpdateDate: 2018/1/30/030 15:08
 */
class Ex42_copyStack<Item> extends NodeList<Item>{

    private Ex42_copyStack(){}
    private Ex42_copyStack(Ex42_copyStack<Item> stack){
        if (stack.first == null) return;
        this.first = new Node(stack.first.item);
        Node current = this.first;
        Node stackCurrent = stack.first;
        while (stackCurrent.next != null){
            current.next = new Node(stackCurrent.next.item);
            current = current.next;
            stackCurrent = stackCurrent.next;
        }
    }

    void push(Item item){
        if (first == null)
            first = new Node(item);
        else {
            Node n = new Node(item);
            n.next = first;
            first = n;
        }
    }

    void pop(){
        if (first == null) throw new NoSuchElementException();
        Item item = first.item;
        if (first.next == null)
            first = null;
        first = first.next;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        Ex42_copyStack<Integer> stack = new Ex42_copyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Ex42_copyStack<Integer> anotherStack = new Ex42_copyStack<>(stack);
        System.out.println(anotherStack);
        anotherStack.pop();
        System.out.println(stack);
        System.out.println(anotherStack);
    }
}
