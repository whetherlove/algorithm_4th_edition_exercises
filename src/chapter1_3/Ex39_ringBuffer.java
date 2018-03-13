package chapter1_3;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/30/030 14:25
 * @UpdateDate: 2018/1/30/030 14:25
 */
class Ex39_ringBuffer<Item> {

    private final int MAX = 100;
    @SuppressWarnings("unchecked")
    private final Item[] buffer = (Item[]) new Object[MAX];
    private int tail = 0;

    void write(Item item){
        if (tail == MAX)
            System.out.println("The ring buffer is currently full.");
        else buffer[tail++] = item;
    }

    Item read(){
        if (tail == 0){
            System.out.println("The ring buffer is currently empty.");
            return null;
        }
        Item item = buffer[0];
        System.arraycopy(buffer, 1, buffer, 0, tail);
        tail--;
        return item;
    }

    int size(){
        return tail;
    }

    public static void main(String[] args) {
        Ex39_ringBuffer<String> buffer = new Ex39_ringBuffer<>();
        buffer.write("123");
        buffer.write("456");
        System.out.println(buffer.size());
        System.out.println(buffer.read());
        System.out.println(buffer.read());
        System.out.println(buffer.read());
        System.out.println(buffer.size());
    }
}
