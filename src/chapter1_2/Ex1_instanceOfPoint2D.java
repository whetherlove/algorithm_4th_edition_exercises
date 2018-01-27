package chapter1_2;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_2
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/25/025 10:04
 * @UpdateDate: 2018/1/25/025 10:04
 */
public class Ex1_instanceOfPoint2D {

    public static void main(String[] args) {

        StdDraw.setCanvasSize(500,500);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.01);

        System.out.println("Enter the number of points:");
        int n = StdIn.readInt();
        Point2D[] points = new Point2D[n];
        Point2D[] generatedPoints = Arrays.stream(points)
                .map(e -> new Point2D(Math.random(),Math.random()))
                .peek(Point2D::draw)
                .toArray(Point2D[]::new);

        double minDistance = Double.MAX_VALUE;
        for (int i=0;i<generatedPoints.length;i++){
            for (int j=i+1;j<generatedPoints.length;j++){
                double distance = generatedPoints[i].distanceTo(generatedPoints[j]);
                if (distance<minDistance)
                    minDistance = distance;
            }
        }
        System.out.println("min distance:" + minDistance);


    }
}
