package chapter2_5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_5
 * @Description:
 * @date 13/03/2018 4:19 PM
 */
public class Ex16_fairOrder implements Comparator{

    private final String[] ORDER =
            {"R","W","Q","O","J","M","V","A","H","B","S","G","Z",
                    "X","N","T","C","I","E","K","U","P","D","Y","F","L"};
    private HashMap<String,Integer> map = new HashMap<>();

    public Ex16_fairOrder() {
        int index = 1;
        for (String s : ORDER)
            map.put(s,index++);
    }

    @Override
    public int compare(Object o1, Object o2) {
        String s1 = ((String) o1).substring(0,1);
        String s2 = ((String) o2).substring(0,1);
        return map.get(s1).compareTo(map.get(s2));
    }

    public static void main(String[] args) {
        String[] a = {"OAD","CWW","BAV","DR","EQQQ"};
        Arrays.sort(a,new Ex16_fairOrder());
        System.out.println(Arrays.toString(a));
    }
}
