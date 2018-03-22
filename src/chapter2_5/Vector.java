package chapter2_5;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_5
 * @Description:
 * @date 17/03/2018 12:15 PM
 */
public class Vector implements Comparable{

    private int d;
    private int[] data;

    public Vector(int d) {
        this.d = d;
        data = new int[d];
    }

    public Vector(int d, int...data) {
        this.d = d;
        this.data = data;
    }

    @Override
    public int compareTo(Object o) {
        Vector v = (Vector)o;
        if (d != ((Vector) o).d)
            throw new IllegalArgumentException();
        int pos = 0;
        while (data[pos] == v.data[pos] && pos < d)
            pos++;
        return data[pos] - v.data[pos];
    }
}
