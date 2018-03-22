package chapter2_5;

import edu.princeton.cs.algs4.MinPQ;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_5
 * @Description:
 * @date 21/03/2018 7:27 PM
 */
public class Ex32_EightProblem {

    //目标状态：   0代表空格
    // 1 2 3
    // 4 5 6
    // 7 8 0

    //f(n) = g(n) + h(n)。
    //g(n):从起始状态到达九宫格当前状态所需的步数
    //h(n):错位的格子数量

    private static final int[][] targetStatus = {{1,2,3},{4,5,6},{7,8,0}};
    private static final int[] targetI = {1,1,1,2,2,2,3,3,3};
    private static final int[] targetJ = {1,2,3,1,2,3,1,2,3};

    private MinPQ<Node> openList = new MinPQ<>();
    private ArrayList<Node> closedList = new ArrayList<>();
    //追溯表comeFrom：存储父子节点关系的列表，用于追溯生成路径。
    private ArrayList<Node> comeFrom = new ArrayList<>();

    public static boolean contains(MinPQ<Node> openList, Node n){
        for (Node node : openList) {
            if (Arrays.deepEquals(node.status, n.status))
                return true;
        }
        return false;
    }

    public static boolean contains(ArrayList<Node> closedList, Node n){
        for (Node node : closedList)
            if (Arrays.deepEquals(node.status,n.status) && node.gn == n.gn)
                return true;
        return false;
    }

    private ArrayList<Node> getAdj(Node n) {
        ArrayList<Node> adjacentNodes = new ArrayList<>();
        //get space(0) position
        int spaceI = -1;
        int spaceJ = -1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (n.status[i][j] == 0){
                    spaceI = i;
                    spaceJ = j;
                }
            }
        }
        //get up
        if (spaceI != 2){
            int[][] up = new int[3][3];
            for (int i = 0; i < 3; i++)
                System.arraycopy(n.status[i], 0, up[i], 0, 3);
            up[spaceI][spaceJ] = up[spaceI+1][spaceJ];
            up[spaceI+1][spaceJ] = 0;
            adjacentNodes.add(new Node(up));
        }
        //get down
        if (spaceI != 0){
            int[][] down = new int[3][3];
            for (int i = 0; i < 3; i++)
                System.arraycopy(n.status[i], 0, down[i], 0, 3);
            down[spaceI][spaceJ] = down[spaceI-1][spaceJ];
            down[spaceI-1][spaceJ] = 0;
            adjacentNodes.add(new Node(down));
        }
        //get left
        if (spaceJ != 2){
            int[][] left = new int[3][3];
            for (int i = 0; i < 3; i++)
                System.arraycopy(n.status[i], 0, left[i], 0, 3);
            left[spaceI][spaceJ] = left[spaceI][spaceJ+1];
            left[spaceI][spaceJ+1] = 0;
            adjacentNodes.add(new Node(left));
        }
        //get right
        if (spaceJ != 0){
            int[][] right = new int[3][3];
            for (int i = 0; i < 3; i++)
                System.arraycopy(n.status[i], 0, right[i], 0, 3);
            right[spaceI][spaceJ] = right[spaceI][spaceJ-1];
            right[spaceI][spaceJ-1] = 0;
            adjacentNodes.add(new Node(right));
        }
        return adjacentNodes;
    }

    private class Node implements Comparable<Node>{   //结点保存当前九宫格状态并计算估价函数f(n)
        private int[][] status;
        private int gn;
        private int hn;
        private int fn;

        public Node(int[][] currentStatus) {
            status = currentStatus;
            hn = calHn();
        }

        private int calHn() {
            int n = 0;
            for (int i = 0; i < 3 ; i++)
                for (int j = 0; j < 3; j++)
                    if (status[i][j] != targetStatus[i][j])
                        n++;
            return n;
        }

        @Override
        public int compareTo(Node o) {
            return fn - o.fn;
        }

        @Override
        public String toString() {
            return "" + status[0][0] + " " + status[0][1] + " " + status[0][2] + "\n" +
                        status[1][0] + " " + status[1][1] + " " + status[1][2] + "\n" +
                        status[2][0] + " " + status[2][1] + " " + status[2][2] + "\n";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return Arrays.deepEquals(status, node.status);
        }

        @Override
        public int hashCode() {
            return Arrays.deepHashCode(status);
        }
    }

    //A-star算法

    //选出open表中的Fn值最小的节点，将此节点设为当前节点，移出open表，同时加入close表。
    //取出当前结点的相邻结点，当相邻结点在close表中时，不操作。
    //此外，查看相邻结点是否在open表中，如不在open表中将相邻结点加入open表。
    //如相邻结点已经在open表中，则需要进行G值判定

    //G值判定
    //对于相邻结点在开启列表中的，计算相邻结点的G值，计算按照当前路径的G值与原开启列表中的G值大小。
    //如果当前路径G值小于原开启列表G值，则相邻点以当前点为父节点，将相邻点与当前点加入追溯表中。
    //同时更新此相邻点的H值。如果当前路径G值大于等于原开启列表G值，则相邻点按照原开启列表中的
    //节点关系，H值不变。因为图示中，当前点G值比原开启列表G值大，因此节点关系按照原父子关系和F值。

    public void solve(int[][] startStatus){
        //初始化
        Node startNode = new Node(startStatus);
        startNode.gn = 0;
        startNode.fn = startNode.gn + startNode.hn;
        openList.insert(startNode);
        comeFrom.add(startNode);
        //A-star
        ArrayList<Node> adjacentNodes;  //每个结点至多有4个后续结点， 以滑块移动方向记为up，down, left, right
        while (!openList.isEmpty()){
            //从open表中取估价值fn最小的节点
            Node currentNode = openList.delMin();
            adjacentNodes = getAdj(currentNode);
            //将该结点加入closed表
            closedList.add(currentNode);
            //如果当前结点即目标节点,success
            if (Arrays.deepEquals(currentNode.status,targetStatus))
                break;
            //扩展当前结点，获取所有可能的相邻结点
            for (Node n : adjacentNodes){
                //如果相邻结点已在closed表，不操作
                if (contains(closedList,n))
                    continue;
                //如果相邻结点不在open表，将相邻结点加入open表
                if (!contains(openList,n)) {
                    n.gn = currentNode.gn + 1;
                    n.fn = n.gn + n.hn;
                    openList.insert(n);
                    continue;
                }
                //如相邻结点已经在open表中，则需要进行G值判定
                if (contains(openList,n)){
                    if (n.gn > currentNode.gn + 1)
                        for (Node node : openList){
                            if (Arrays.deepEquals(node.status,n.status)) {
                                node.gn = currentNode.gn + 1;
                                node.fn = node.gn + node.hn;
                            }
                    }
                    //FIXME
                    //不会写
                }
            }
            System.out.println(currentNode);
        }
        for (Node n : comeFrom)
            System.out.println(n);
    }

    public static void main(String[] args) {
        int[][] startStatus = {{1,2,3},{4,0,5},{6,8,7}};
        Ex32_EightProblem problem = new Ex32_EightProblem();
        problem.solve(startStatus);
    }
}
