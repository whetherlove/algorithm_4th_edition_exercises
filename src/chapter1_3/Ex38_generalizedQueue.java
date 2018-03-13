package chapter1_3;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/30/030 13:34
 * @UpdateDate: 2018/1/30/030 13:34
 */
@SuppressWarnings("SameParameterValue")
class Ex38_generalizedQueue<Item> {
    //数组大小可使用resize改变 此处为图方便设为定长
    //满足题意的最减做法：使用数组角标记录插入顺序

    @SuppressWarnings("unchecked")
    private final Item[] queue = (Item[]) new Object[100];
    private int pos = 0;

    public boolean isEmpty(){
        for (int i=0;i<=pos;i++){
            if (queue[i] != null)
                return false;
        }
        return true;
    }

    void insert(Item x){
        if (pos == queue.length) throw new ArrayIndexOutOfBoundsException();
        queue[pos++] = x;
    }

    void delete(int k){
        if (k>queue.length-1) throw new ArrayIndexOutOfBoundsException();
        Item item = queue[k];
        queue[k-1] = null;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i=0;i<=pos;i++)
            if (queue[i] != null)
                s.append(queue[i].toString());
        return s.toString();
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        Ex38_generalizedQueue<Integer> queue = new Ex38_generalizedQueue();
        queue.insert(1);
        queue.insert(3);
        queue.insert(5);
        queue.delete(2);
        System.out.println(queue);
    }
}
