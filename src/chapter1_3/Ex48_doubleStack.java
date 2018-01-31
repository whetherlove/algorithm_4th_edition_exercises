package chapter1_3;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/30/030 16:25
 * @UpdateDate: 2018/1/30/030 16:25
 */
public class Ex48_doubleStack<Item> {

    private Ex33_deque<Item> doubleStack = new Ex33_deque();
    private int sizeOne = 0;
    private int sizeTwo = 0;

    public void pushOne(Item item){
        doubleStack.pushLeft(item);
        sizeOne++;
    }

    public void pushTwo(Item item){
        doubleStack.pushRight(item);
        sizeTwo++;
    }

    public Item popOne(){
        if (sizeOne == 0) throw new IndexOutOfBoundsException();
        sizeOne--;
        return doubleStack.popLeft();
    }

    public Item popTwo(){
        if (sizeTwo == 0) throw new IndexOutOfBoundsException();
        sizeTwo--;
        return doubleStack.popRight();
    }

    public int getSizeOne(){
        return sizeOne;
    }

    public int getSizeTwo(){
        return sizeTwo;
    }

    public static void main(String[] args) {
        Ex48_doubleStack<Integer> doubleStack = new Ex48_doubleStack();
        doubleStack.pushOne(1);
        doubleStack.pushOne(2);
        doubleStack.pushTwo(3);
        doubleStack.pushTwo(4);
        System.out.println(doubleStack.popOne());
        System.out.println(doubleStack.popTwo());
    }
}
