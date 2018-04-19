package chapter3_1;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter3_1
 * @Description:
 * @date 30/03/2018 2:27 PM
 */
public class Ex24_arithmeticalKey<Value> {

    private Integer[] keys;

    private Value[] vals;

    private int N;

    private int rank(Integer key) {
        Integer lo = keys[0], hi = keys[N-1];
        while (lo <= hi) {
            int mid = (key-lo) / (hi-key);
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0)
                hi = keys[mid-1];
            else if (cmp > 0)
                lo = keys[mid+1];
            else
                return mid;
        }
        return lo;
    }
}
