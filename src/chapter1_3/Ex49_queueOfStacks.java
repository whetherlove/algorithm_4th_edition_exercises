package chapter1_3;


/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/30/030 16:33
 * @UpdateDate: 2018/1/30/030 16:33
 */
@SuppressWarnings("StatementWithEmptyBody")
class Ex49_queueOfStacks<Item> {
    //双栈实现队列 队列操作均摊到每个元素复杂度为O(1)
    //但最坏情况下复杂度为O(n).
    //目前有一种使用6个栈来完成此题的方法
    //https://www.cnblogs.com/ikesnowy/p/7157813.html
    private final Stack<Item> a = new Stack<>();
    private final Stack<Item> b = new Stack<>();

    private void enqueue(Item item){
        a.push(item);
    }

    private Item dequeue(){
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
