package chapter1_5;

import chapter1_3.Ex34_randomBag;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;

import java.util.*;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_5
 * @Description:
 * @date 9/02/2018 9:53 AM
 */
public class RandomGrid {

    public static Connection[] generate(int N){
        Ex34_randomBag<Connection> bag = new Ex34_randomBag<>();
        //生成横向连接
        for (int i=1;i<N*N;i+=N) {
            int p = i;
            for (int j = 1; j < N; j++) {
                bag.add(new Connection(p, p + 1));
                p++;
            }
        }
        //生成纵向连接
        for (int i = 1; i <N*N-N; i+=N) {
            int p = i;
            for (int j = 0; j < N; j++) {
                bag.add(new Connection(p, p + N));
                p++;
            }
        }
        //生成Connection数组
        List<Connection> connections = new ArrayList<>();
        for(Connection c : bag)
            connections.add(c);
        return connections.toArray(new Connection[bag.size()]);
    }

    public static void main(String[] args) {
        //Ex18
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Connection[] connections = generate(N);
        for (Connection c : connections)
            System.out.println(c);

        //Ex19
        StdDraw.setCanvasSize(500,500);
        HashMap<Integer,Point2D> points = new HashMap<>();
        int pointNum = 1;
        //draw points
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.01);
        double interval = 0.8 / (N-1);
        for (double i=0.1;i<=0.9;i+=interval) {
            for (double j = 0.1; j <= 0.9; j += interval) {
                StdDraw.point(i, j);
                points.put(pointNum++,new Point2D(i,j));
            }
        }
        //draw lines
        StdDraw.setPenRadius(0.002);
        for (Connection c: connections) {
            Point2D p = points.get(c.p);
            Point2D q = points.get(c.q);
            StdDraw.line(p.x(),p.y(),q.x(),q.y());
        }
    }
}

class Connection{
    int p;
    int q;
    public Connection(int p, int q){
        this.p = p;
        this.q = q;
    }

    @Override
    public String toString() {
        return "(" + p + "," + q + ")";
    }
}
