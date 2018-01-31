package chapter1_3;


/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/30/030 16:33
 * @UpdateDate: 2018/1/30/030 16:33
 */
public class Ex49_queueOfStacks<Item> {
    //双栈实现队列 队列操作均摊到每个元素复杂度为O(1)，暂未想到更好的方法
    private Stack<Item> a = new Stack<>();
    private Stack<Item> b = new Stack<>();

    public void enqueue(Item item){
        a.push(item);
    }

    public Item dequeue(){
        if (a.size() == 0);
        else {
            while (a.size() > 0)
                b.push(a.pop());
        }
        return b.pop();
    }

    public static void main(String[] args) {
        //test
        Ex49_queueOfStacks<Integer> queue = new Ex49_queueOfStacks<>();
        queue.enqueue(1);
        System.out.println(queue.dequeue());
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
    }
}
