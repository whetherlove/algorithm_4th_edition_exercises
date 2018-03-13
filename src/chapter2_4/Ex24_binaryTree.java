package chapter2_4;

import edu.princeton.cs.algs4.Queue;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_4
 * @Description:
 * @date 8/03/2018 5:26 PM
 */
class Ex24_binaryTree<Item extends Comparable<Item>> {

    private final Node root = new Node();

    private class Node {
        private Item value;
        private Node parent;
        private Node left;
        private Node right;

        Node(){}

        Node(Item item){
            value = item;
        }

        @Override
        public String toString() {
            return (value!=null?value:" ") +
                    "[" +
                    (left!=null?left:" ") +
                    "," +
                    (right!=null?right:" ") +
                    "]";
        }
    }

    @SuppressWarnings("unchecked")
    void insert(Item item) {
        if (root.value == null) {
            root.value = item;
            return;
        }
        Node node = new Node(item);
        Queue<Node> queue = new Queue();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node temp = queue.dequeue();
            if (temp.left == null) {
                temp.left = node;
                node.parent = temp;
                swim(node);
                return;
            } else if (temp.right == null) {
                temp.right = node;
                node.parent = temp;
                swim(node);
                return;
            } else {
                queue.enqueue(temp.left);
                queue.enqueue(temp.right);
            }
        }
    }

    /**
     * 将新插入的节点不断与父节点比较，若大于父节点，则交换值
     * @param node
     */
    private void swim(Node node){
        while (node.parent != null && node.value.compareTo(node.parent.value) > 0){
            Item temp = node.value;
            node.value = node.parent.value;
            node.parent.value = temp;
            node = node.parent;
        }
    }

    private Item max(){
        return root.value;
    }

    @SuppressWarnings("unchecked")
    Item delMax(){
        Item max = max();
        Node last = root;
        Queue<Node> queue = new Queue();
        queue.enqueue(root);
        while (!queue.isEmpty()){
            Node temp = queue.dequeue();
            if (temp.left == null && temp.right == null) {
                last = temp;
                if (temp.parent.left == temp)
                    temp.parent.left = null;
                else
                    temp.parent.right = null;
                break;
            }
            if (temp.left == null){
                last = temp.right;
                temp.right = null;
                break;
            }
            if (temp.right == null){
                last = temp.left;
                temp.left = null;
                break;
            }
            queue.enqueue(temp.left);
            queue.enqueue(temp.right);
        }
        root.value = last.value;
        System.out.println(root);
        sink();
        return max;
    }

    private void sink(){
        Node current = root;
        while (true){
            //若current没有子节点，结束sink
            if (current.left == null && current.right == null)
                return;
            //若current没有右节点，则必有左节点，若起左节点大于自身，交换其余左节点的值,并另current等于其左节点
            //注：若current没有左节点，则必没有右节点，否则不满足完全二叉树条件
            if (current.right == null && current.value.compareTo(current.left.value) < 0){
                current = current.left;
                Item temp = current.value;
                current.value = current.parent.value;
                current.parent.value = temp;
                continue;
            }
            if (current.left == null && current.value.compareTo(current.right.value) < 0){
                current = current.right;
                Item temp = current.value;
                current.value = current.parent.value;
                current.parent.value = temp;
                continue;
            }
            //若current有左右节点，若左节点值比右节点大，同时比current值大
            //交换其与左节点的值,并另current等于其左节点
            if (current.left != null && current.right != null && current.left.value.compareTo(current.right.value) > 0
                    && current.value.compareTo(current.left.value) < 0){
                current = current.left;
                Item temp = current.value;
                current.value = current.parent.value;
                current.parent.value = temp;
                continue;
            }
            //若current有左右节点，若右节点值比左节点大，同时比current值大
            //交换其与右节点的值,并另current等于其右节点
            if (current.left != null && current.right != null && current.left.value.compareTo(current.right.value) < 0
                    && current.value.compareTo(current.right.value) < 0){
                current = current.right;
                Item temp = current.value;
                current.value = current.parent.value;
                current.parent.value = temp;
                continue;
            }
            break;
        }
    }

    public static void main(String[] args) {
        Ex24_binaryTree<Integer> binaryTree = new Ex24_binaryTree<>();
        binaryTree.insert(2);
        binaryTree.insert(1);
        binaryTree.insert(4);
        binaryTree.insert(3);
        //System.out.println(binaryTree.root);
        System.out.println(binaryTree.delMax());
        System.out.println(binaryTree.root);
        System.out.println(binaryTree.delMax());
        System.out.println(binaryTree.root);
    }
}
