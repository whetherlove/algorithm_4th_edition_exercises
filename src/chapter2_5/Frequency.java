package chapter2_5;

import java.util.*;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_5
 * @Description: Ex8
 * @date 13/03/2018 2:44 PM
 */
public class Frequency {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");

        HashMap<String,Integer> map = new HashMap<>();
        for (String s : words)
            if (map.containsKey(s))
                map.put(s,map.get(s)+1);
            else
                map.put(s,1);

        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (e1,e2) -> e2.getValue()-e1.getValue());

        System.out.println(list);
    }
}
