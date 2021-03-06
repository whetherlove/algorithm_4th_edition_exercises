package chapter1_3;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/28/028 15:33
 * @UpdateDate: 2018/1/28/028 15:33
 */
public class Ex14_resizingArrayQueueOfString {

    private String[] a = new String[1];
    private int N = 0;

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    private void resize(int max){
        String[] temp = new String[max];
        System.arraycopy(a, 0, temp, 0, N);
        a = temp;
    }
    public void enQueue(String s){
        if (N == a.length)
            resize(2 * a.length);
        a[N++] = s;
    }

    public String deQueue(){
        String s = a[0];
        System.arraycopy(a, 1, a, 0, N - 1);
        a[N--] = null;
        if (N > 0 && N == a.length / 4)
            resize(a.length / 2);
        return s;
    }

    public static void main(String[] args) {

        //Exercise 15
        int k = 4;
        Ex14_resizingArrayQueueOfString queue = new Ex14_resizingArrayQueueOfString();
        String[] test = {"5","4","3","2","1"};
        for (String aTest : test) queue.enQueue(aTest);
        for (int i = 0; i < queue.size() - k; i++)
            queue.deQueue();
        System.out.println(queue.deQueue());

    }
}
