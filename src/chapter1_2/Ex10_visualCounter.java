package chapter1_2;

import edu.princeton.cs.algs4.StdDraw;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_2
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/27/027 15:11
 * @UpdateDate: 2018/1/27/027 15:11
 */
public class Ex10_visualCounter {

    private final int N;
    private final int max;
    private int value;
    private int operatedTimes;

    Ex10_visualCounter(int n, int max){
        this.N = n;
        this.max = max;
        this.value = 0;
        this.operatedTimes = 0;
    }
    public void increment(){
        if (value<max && operatedTimes<N){
            value++;
            operatedTimes++;
        }
        draw();
    }
    public void decrement(){
        if (this.value>-max && operatedTimes<N){
            this.value--;
            operatedTimes++;
        }
        draw();
    }
    public void draw(){
        StdDraw.clear();
        StdDraw.text(0.5,0.5,"counter:"+value);
    }

    public static void main(String[] args) throws InterruptedException {

        Ex10_visualCounter visualCounter = new Ex10_visualCounter(100,100);
        visualCounter.increment();
        Thread.sleep(1000);
        visualCounter.increment();
        Thread.sleep(1000);
        visualCounter.decrement();
    }

}
