package chapter2_1;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;
import java.util.Comparator;

import static java.util.Arrays.sort;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_1
 * @Description:
 * @date 24/02/2018 4:50 PM
 */
@SuppressWarnings("ConstantConditions")
class Ex32_curveGraph {

    private static void init(){
        StdDraw.setCanvasSize(1000,500);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.005);
        StdDraw.line(0.0125,0.05,0.975,0.05);
        StdDraw.line(0.025,0.025,0.025,0.975);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.03);
    }

    private static void draw(ArrayList<Point2D> points){
        double min = points.stream().map(Point2D::y).min(Comparator.comparing(num -> num)).get();
        double max = points.stream().map(Point2D::y).max(Comparator.comparing(num -> num)).get();
        points.stream()
                .map(p -> new Point2D(p.x(),uniformY(p.y(),max,min)))
                .forEach(p -> StdDraw.point(p.x(),p.y()));
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.005);
        for (int i=1; i<points.size(); i++)
            StdDraw.line(points.get(i).x(),
                    uniformY(points.get(i).y(),max,min),
                    points.get(i-1).x(),
                    uniformY(points.get(i-1).y(),max,min));

    }
    //将所有点的纵坐标map到0.5-0.95之间 令f(y) = ay + b
    private static double uniformY(double y, double max, double min){
        double a = 0.9 / (max - min);
        double b = 0.95 - max*a;
        return a*y + b;
    }

    public static void main(String[] args) {
        ArrayList<Point2D> points = new ArrayList<>();
        init();
        int size = 100;
        for (double i=0.1;i<1;i+=0.2){
            double[] a = Ex17_animation.generate(size);
            long t0 = System.currentTimeMillis();
            sort(a);
            long t1 = System.currentTimeMillis();
            long t = t1-t0;
            points.add(new Point2D(i,t));
            System.out.print(t + " ");
            size*=10;
        }
        draw(points);
    }
}
