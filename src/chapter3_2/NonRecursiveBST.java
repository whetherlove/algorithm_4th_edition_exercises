package chapter3_2;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter3_2
 * @Description:
 * @date 31/03/2018 1:54 PM
 */
public class NonRecursiveBST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node{
        private Key key;
        private Value value;
        private Node left, right;
        private int N;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }
    }

    public int size(){
        if (root == null) return 0;
        return root.N;
    }

    public Value get(Key key){
        Node x = root;
        while (x != null){
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x.value;
            else if (cmp < 0) x = x.left;
            else x = x.right;
        }
        return null;
    }

    public void put(Key key, Value value){
        if (root == null) {
            root = new Node(key,value,1);
            return;
        }
        Node x = root;
        ArrayList<Node> path = new ArrayList<>();
        while (x != null){
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                x.value = value;
                return;
            }
            if (cmp < 0 && x.left == null){
                path.add(x);
                x.left = new Node(key,value,1);
                path.forEach(node -> node.N++);
                return;
            }
            if (cmp > 0 && x.right == null){
                path.add(x);
                x.right = new Node(key,value,1);
                path.forEach(node -> node.N++);
                return;
            }
            if (cmp < 0){
                path.add(x);
                x = x.left;
            }
            else {
                path.add(x);
                x = x.right;
            }
        }
    }
}
