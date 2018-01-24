package chapter1_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/24/024 13:44
 * @UpdateDate: 2018/1/24/024 13:44
 */
public class Ex31_randomLink {

    public static void main(String[] args) {
        //init canvas
        StdDraw.setCanvasSize(500, 500);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.0005);
        StdDraw.circle(0.5, 0.5, 0.3);
        //get parametters
        System.out.println("Enter the number of points:");
        int n = StdIn.readInt();
        System.out.println("Enter the possibility of linking two points:");
        double p = StdIn.readDouble();
        //draw points
        double distance = 2 * Math.PI / n;
        StdDraw.setPenRadius(0.05);
        ArrayList<Point> points = new ArrayList<>();
        for (double angle = 0.0; angle < 2 * Math.PI; angle += distance) {
            double x = 0.5 + 0.3 * Math.sin(angle);
            double y = 0.5 + 0.3 * Math.cos(angle);
            StdDraw.point(x, y);
            points.add(new Point(x, y));
        }
        //draw lines
        for (int i=0;i<points.size();i++){
            for (int j=0;j<i;j++){
                if (i != j && Math.random()<p)
                    StdDraw.line(points.get(i).x,points.get(i).y,
                            points.get(j).x,points.get(j).y);
            }
        }
    }
}

class Point {
    double x;
    double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}



