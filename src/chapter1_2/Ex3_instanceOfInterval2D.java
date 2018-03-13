package chapter1_2;

import edu.princeton.cs.algs4.*;

import java.util.Arrays;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_2
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/27/027 11:46
 * @UpdateDate: 2018/1/27/027 11:46
 */
class Ex3_instanceOfInterval2D {

    public static void main(String[] args) {

        StdDraw.setCanvasSize(500,500);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.005);

        System.out.print("Enter the number of intervals:");
        int n = StdIn.readInt();
        System.out.print("Specify the min length:");
        double min = StdIn.readDouble();
        System.out.print("Specify the max length:");
        double max = StdIn.readDouble();

        Interval2D[] intervals = new Interval2D[n];
        Interval2D[] interval2Ds = Arrays.stream(intervals)
                .map(e -> generator(min,max))
                .peek(Interval2D::draw)
                .toArray(Interval2D[]::new);

        int intersects = 0;
        int contains = 0;
        for (int i=0;i<interval2Ds.length;i++){
            for (int j=i+1;j<interval2Ds.length;j++){
                if (interval2Ds[i].intersects(interval2Ds[j]))
                    intersects++;
                if (contains(interval2Ds[i],interval2Ds[j]))
                    contains++;
            }
        }
        System.out.println("intersect pairs: " + intersects);
        System.out.println("contains pairs: " + contains);

    }
    private static Interval2D generator(double min, double max){
        double width = StdRandom.uniform(min,max);
        double height = StdRandom.uniform(min,max);
        double posX = StdRandom.uniform(0,1-max);
        double posY = StdRandom.uniform(-max,1);
        return new Interval2D(
                new Interval1D(posX,posX+width),
                new Interval1D(posY,posY+height)
        );
    }
    //Intervals2D 并未提供contains方法，可自行写一个
    //由于Intervals2D中坐标信息均为private,
    //通过parse其toString方法得到对应点
    //此处统一返回false;
    private static boolean contains(Interval2D a, Interval2D b){
        return false;
    }
}
