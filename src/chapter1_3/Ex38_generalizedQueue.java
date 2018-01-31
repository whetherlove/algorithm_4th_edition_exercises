package chapter1_3;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/30/030 13:34
 * @UpdateDate: 2018/1/30/030 13:34
 */
public class Ex38_generalizedQueue<Item> {
    //数组大小可使用resize改变 此处为图方便设为定长
    //满足题意的最减做法：使用数组角标记录插入顺序

    private Item[] queue = (Item[]) new Object[100];
    private int pos = 0;

    public boolean isEmpty(){
        for (int i=0;i<=pos;i++){
            if (queue[i] != null)
                return false;
        }
        return true;
    }

    public void insert(Item x){
        if (pos == queue.length) throw new ArrayIndexOutOfBoundsException();
        queue[pos++] = x;
    }

    public Item delete(int k){
        if (k>queue.length-1) throw new ArrayIndexOutOfBoundsException();
        Item item = queue[k];
        queue[k-1] = null;
        return item;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i=0;i<=pos;i++)
            if (queue[i] != null)
                s += queue[i].toString();
        return s;
    }

    public static void main(String[] args) {

        Ex38_generalizedQueue<Integer> queue = new Ex38_generalizedQueue();
        queue.insert(1);
        queue.insert(3);
        queue.insert(5);
        queue.delete(2);
        System.out.println(queue);
    }
}
