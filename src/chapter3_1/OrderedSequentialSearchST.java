package chapter3_1;

import edu.princeton.cs.algs4.Queue;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter3_1
 * @Description:
 * @date 29/03/2018 9:26 AM
 */
public class OrderedSequentialSearchST<Key extends Comparable<Key>, Value> {

    private Node first;

    private int N;

    private class Node {
        Key key;

        Value val;

        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public void put(Key key, Value value) {
        N++;
        if (first == null) {
            first = new Node(key, value, null);
            return;
        }
        Node current = first;
        while (current.next != null && current.next.key.compareTo(key) > 0)
            current = current.next;
        if (current.next == null)
            current.next = new Node(key, value, null);
        else {
            current.next = new Node(key, value, current.next);
        }
    }

    public void delete(Key key) {
        if (first.key.equals(key)) {
            first = first.next;
            N--;
            return;
        }
        Node current = first;
        while (current.next != null && !current.next.key.equals(key))
            current = current.next;
        if (current.next == null)
            return;
        else {
            current.next = current.next.next;
            N--;
        }
    }

    public Key min() {
        if (first == null)
            throw new ArrayIndexOutOfBoundsException();
        return first.key;
    }

    public Key max() {
        if (first == null)
            throw new ArrayIndexOutOfBoundsException();
        Node current = first;
        while (current.next != null)
            current = current.next;
        return current.key;
    }

    public Key floor(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key.compareTo(key) >= 0)) {
                return x.key;
            }
        }
        return null;
    }

    public Key ceiling(Key key) {
        for (Node x = first; x.next != null; x = x.next) {
            if (key.equals(x.next.key.compareTo(key) <= 0)) {
                return x.key;
            }
        }
        return null;
    }

    public int rank(Key key) {
        if (first == null)
            return 0;
        int rank = 0;
        Node current = first;
        while (current != null && current.key.compareTo(key) < 0) {
            rank++;
            current = current.next;
        }
        return rank;
    }

    public Key select(int k) {
        if (k < 0 && k > N - 1)
            throw new ArrayIndexOutOfBoundsException();
        if (first == null)
            return null;
        Node current = first;
        for (int count = 0; count < k; count++) {
            current = current.next;
        }
        return current.key;
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        if (first == null)
            return null;
        Queue<Key> queue = new Queue<>();
        Node current = first;
        while (current != null) {
            if (current.key.compareTo(lo) >= 0)
                queue.enqueue(current.key);
            if (current.key.compareTo(hi) > 0)
                break;
            current = current.next;
        }
        return queue;
    }

    // get contains isEmpty size 同SequentialSearchST
    // deleteMin deleteMax size(Key lo, Key hi) keys 同表3.1.6默认实现
}
