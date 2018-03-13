package chapter2_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_1
 * @Description:
 * @date 24/02/2018 1:00 PM
 */
@SuppressWarnings("SameParameterValue")
class Ex17_animation {

    private static void init(int N){
        StdDraw.setCanvasSize(1000,500);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.enableDoubleBuffering();
    }

    public static double[] generate(int N){
        double[] doubles = new double[N];
        for (int i = 0; i < N; i++) {
            doubles[i] = StdRandom.uniform();
        }
        return doubles;
    }

    private static void drawFrame(double[] a, ArrayList black, int red){
        int N = a.length;
        double colWidth = 1.0 / (N+1) * 1.5;
        double colInterval = 1.0 / (N+1);
        StdDraw.setPenRadius(colWidth);
        double pos = 0;
        for (int i = 0; i < a.length; i++) {
            pos+=colInterval;
            if (i == red){
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.line(pos,0,pos,a[i]);
            }
            else if (black.contains(i)){
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.line(pos,0,pos,a[i]);
            }
            else {
                StdDraw.setPenColor(StdDraw.GRAY);
                StdDraw.line(pos,0,pos,a[i]);
            }

        }
    }

    private static void start(double[] a, ArrayList black, int red) throws InterruptedException {
        drawFrame(a,black,red);
        StdDraw.show();
        Thread.sleep(1000);
        StdDraw.clear();
    }

    public static void selection(int N) throws InterruptedException {
        double[] a = generate(N);
        init(N);
        for (int i = 0; i < N; i++) {
            //黑色为参与比较过的元素
            ArrayList<Integer> black = new ArrayList<>();
            for (int j = i+1; j < N; j++) {
                black.add(j);
                if (a[j] < a[i]){
                    double temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
            //红色为未排序中最小的
            Double min = Double.MAX_VALUE;
            int red = -1;
            for (Integer p : black) {
                if (a[p] < min) {
                    min = a[p];
                    red = p;
                }
            }
            start(a,black,red);
        }
    }

    private static void insertion(int N) throws InterruptedException {
        double[] a = generate(N);
        init(N);
        for (int i = 0; i < N; i++) {
            //黑色为参与比较过的元素
            ArrayList<Integer> black = new ArrayList<>();
            double target = a[i];
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j-1]) {
                    black.add(j);
                    double temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
            //红色为一次排序后i插入的位置
            int red = -1;
            for (int k=0;k<=i;k++) {
                if (a[k] == target) {
                    red = k;
                    break;
                }
            }
            start(a,black,red);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //selection(100);
        insertion(100);
    }
}
