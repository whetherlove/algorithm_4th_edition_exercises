package chapter2_4;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_4
 * @Description:
 * @date 9/03/2018 7:21 PM
 */
class Ex28_topM {

    public static void main(String[] args) {

        int M = 10000;
        MinPQ<Coordinate> minPQ = new MinPQ<>(M + 1);
        while (StdIn.hasNextLine()){
            minPQ.insert(new Coordinate(StdIn.readLine()));
            if (minPQ.size() > M)
                minPQ.delMin();
        }
        Stack<Coordinate> stack = new Stack<>();
        while (!minPQ.isEmpty())
            stack.push(minPQ.delMin());
        for (Coordinate c : stack)
            StdOut.println(c);
    }
}

class Coordinate{
    private final double x;
    private final double y;
    private final double z;

    //假设表中输入中每行代表一个坐标，其格式为(x,y,z)
    public Coordinate(String line) {
        String[] coods = line.replaceAll("[()]","").split(",");
        this.x = Double.parseDouble(coods[0]);
        this.y = Double.parseDouble(coods[1]);
        this.z = Double.parseDouble(coods[2]);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + "," + z + ")";
    }
}