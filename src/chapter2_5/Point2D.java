package chapter2_5;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_5
 * @Description:
 * @date 21/03/2018 4:56 PM
 */
public class Point2D {

    private double x;
    private double y;
    private double r;
    private double theta;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
        r = Math.sqrt(x*x + y*y);
        theta = Math.atan2(y,x);
    }

    private double distanceTo(Point2D p){
        return Math.sqrt((y-p.y)*(y-p.y) + (x-p.x)*(x-p.x));
    }

    private double thetaTo(Point2D p){
        return Math.atan2(p.y-y,p.x-x);
    }

    public void draw(){
        StdDraw.point(x,y);
    }

    public static class XOrder implements Comparator<Point2D>{

        @Override
        public int compare(Point2D o1, Point2D o2) {
            return Double.compare(o1.x, o2.x);
        }
    }

    public static class YOrder implements Comparator<Point2D>{

        @Override
        public int compare(Point2D o1, Point2D o2) {
            return Double.compare(o1.y, o2.y);
        }
    }

    public static class ROrder implements Comparator<Point2D>{

        @Override
        public int compare(Point2D o1, Point2D o2) {
            return Double.compare(o1.r, o2.r);
        }
    }

    Comparator<Point2D> distanceOrder = Comparator.comparingDouble(this::distanceTo);

    Comparator<Point2D> thetaOrder = Comparator.comparingDouble(this::thetaTo);



    public static void main(String[] args) {
        //Ex26 ... for testing Ex25
        ArrayList<Point2D> points = new ArrayList<>();
        int N = 5;
        for (int i = 0; i < N-1; i++)
            points.add(new Point2D(StdRandom.uniform(0.15,0.9),StdRandom.uniform(0.1,0.9)));
        Point2D startPoint = new Point2D(0.5,0.1);
        points.sort(startPoint.thetaOrder);
        System.out.println(points.size());
        points.add(0,startPoint);
        System.out.println(points.size());

        StdDraw.setCanvasSize(500,500);
        for (int i = 0; i < N-1; i++)
            StdDraw.line(points.get(i).x,points.get(i).y,points.get(i+1).x,points.get(i+1).y);
        StdDraw.line(points.get(N-1).x,points.get(N-1).y,startPoint.x,startPoint.y);


    }
}
