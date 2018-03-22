package chapter2_5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_5
 * @Description:
 * @date 13/03/2018 3:16 PM
 */
public class SPT {

    static class Task implements Comparable{
        String name;
        String time;

        Task(String name, String time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public int compareTo(Object o) {
            return time.compareTo(((Task)o).time);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }

        ArrayList<Task> list = new ArrayList<>();
        for (String s : lines){
            String[] t = s.split(" ");
            list.add(new Task(t[0],t[1]));
        }

        list.sort(Comparator.naturalOrder());

        System.out.println(list);
    }
}
