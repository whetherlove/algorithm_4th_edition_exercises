package chapter1_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/24/024 14:53
 * @UpdateDate: 2018/1/24/024 14:53
 */
class Ex32_histogram {
    private static final double[] input = {1.0,2.0,3.0,3.0};

    public static void main(String[] args) {

        StdDraw.setCanvasSize(500,300);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.0005);
        double unitHeight = 0.05;
        double startPos = 0.2;

        System.out.println("Enter the number of columns:");
        int N = StdIn.readInt();
        System.out.println("Enter the interval:");
        double l = StdIn.readDouble();
        double r = StdIn.readDouble();

        double colWidth = (r-l) / N;

        for (int i=0;i<N;i++){
            double left = l + i*colWidth;
            double right = left + colWidth;
            double height = getUnitNum(left,right)*unitHeight;
            //直方图柱子应动态调整，此处设置为固定值
            StdDraw.rectangle(startPos,0.5,0.1,height);
            startPos += 0.3;
        }

    }

    private static double getUnitNum(double l, double r){
        return Arrays.stream(input).filter(e -> e>l && e< r).count();

    }
}
