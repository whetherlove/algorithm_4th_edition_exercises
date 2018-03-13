package chapter1_3;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/30/030 14:33
 * @UpdateDate: 2018/1/30/030 14:33
 */
class Ex40_moveToFront {

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String in = scanner.next();
            if (list.contains(in)){
                list.remove(in);
                list.addFirst(in);
            }else
                list.addFirst(in);
            System.out.println(list);
        }
    }
}
