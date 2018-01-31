package chapter1_3;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/29/029 11:10
 * @UpdateDate: 2018/1/29/029 11:10
 */
public class ResizingArrayDeque<Item> extends ResizingArrayStack<Item>{

        public void pushLeft(Item item){
            if (N == a.length) {
                resize(2 * a.length);
            }
            for (int i=N;i>1;i--)
                a[i+1] = a[N];
            a[0] = item;
            N++;
        }

        public Item popLeft(){
            Item item = a[0];
            //将弹出的对象设为null,避免对象游离
            for (int i=0;i<N-1;i++)
                a[i] = a[i+1];
            a[N-1] = null;
            if (N > 0 && N == a.length / 4) {
                resize(a.length / 2);
            }
            N--;
            return item;
        }

        public void pushRight(Item item){
            push(item);
        }

        public Item popRight(){
            return (Item) pop();
        }

    public static void main(String[] args) {
        //test
        ResizingArrayDeque<Integer> deque = new ResizingArrayDeque<>();
        deque.pushLeft(1);
        System.out.println(deque.size());
        deque.pushRight(2);
        System.out.println(deque.size());
        System.out.println(deque.popLeft());
        System.out.println(deque.popRight());


    }
}
