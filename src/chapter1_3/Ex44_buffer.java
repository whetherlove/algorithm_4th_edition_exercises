package chapter1_3;

import edu.princeton.cs.algs4.Stack;

import java.util.Iterator;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/30/030 15:22
 * @UpdateDate: 2018/1/30/030 15:22
 */
@SuppressWarnings("SameParameterValue")
class Ex44_buffer {

    private final Stack<Character> main = new Stack<>();
    private final Stack<Character> sup = new Stack<>();

    private void insert(char c){
        main.push(c);
    }

    public char delete(){
        return main.pop();
    }

    private void left(int k){
        if (k>size()) k=size();
        for (int i=0;i<k;i++)
            sup.push(main.pop());
    }

    public void right(int k){
        for (int i=0;i<k;i++)
            main.push(sup.pop());
    }

    private int size(){
        return main.size()+sup.size();
    }

    @Override
    public String toString() {
        Iterator mainIt = main.iterator();
        Iterator supIt = sup.iterator();
        StringBuilder s = new StringBuilder("main:");
        while (mainIt.hasNext())
            s.append(mainIt.next());
        s.append(" sup:");
        while (supIt.hasNext())
            s.append(supIt.next());
        return s.toString();
    }

    public static void main(String[] args) {
        //test
        Ex44_buffer buffer = new Ex44_buffer();
        buffer.insert('a');
        buffer.insert('b');
        buffer.insert('c');
        System.out.println(buffer);
        buffer.left(1);
        System.out.println(buffer);
    }
}
