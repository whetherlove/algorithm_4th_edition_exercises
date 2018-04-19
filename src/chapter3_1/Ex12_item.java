package chapter3_1;

import edu.princeton.cs.algs4.Merge;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter3_1
 * @Description:
 * @date 29/03/2018 2:08 PM
 */
public class Ex12_item<Item extends Comparable<Item>> {

    private Item[] items;

    public Ex12_item(Item[] items) {
        this.items = items;
        Merge.sort(items);
    }
}
