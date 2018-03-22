package chapter2_5;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_5
 * @Description:
 * @date 21/03/2018 8:27 AM
 */
public class Ex22_stock {

    private static class Investigator{

        private int id;
        private int maxIn;              //最多买多少份股票
        private int maxOut;             //最多卖多少份股票
        private double highestIn;
        private double lowestOut;

        Investigator(int id) {
            this.id = id;
            highestIn = StdRandom.uniform(20,40);
            lowestOut = highestIn + StdRandom.uniform(5,10);
            maxIn = StdRandom.uniform(100,200);
            maxOut = StdRandom.uniform(100,200);
        }

        @Override
        public String toString() {
            return "{" + id + ": In=" + highestIn + " Out=" + lowestOut + "}";
        }
    }

    private Investigator currentBuyer;
    private Investigator currentSeller;
    //使用排序后的队列代替优先队列，以方便实现某些功能
    private Queue<Investigator> sellers = new Queue<>();
    private Queue<Investigator> buyers = new Queue<>();

    private void init(ArrayList<Investigator> a){
        a.sort(Comparator.comparingDouble(e -> e.lowestOut));
        for (int i = 0; i < a.size(); i++)
            sellers.enqueue(a.get(i));
        a.sort(Comparator.comparingDouble(e -> e.lowestOut));
        for (int i = a.size()-1; i > -1 ; i--)
            buyers.enqueue(a.get(i));
        System.out.println("sellers:" + sellers);
        System.out.println("buyers:" + buyers);
    }

    private void trade(){
        currentSeller = sellers.dequeue();
        currentBuyer = buyers.dequeue();
        while (!sellers.isEmpty() && !buyers.isEmpty()){
            if (currentSeller.maxOut == 0)
                currentSeller = sellers.dequeue();
            if (currentBuyer.maxIn == 0)
                currentBuyer = buyers.dequeue();
            if (currentSeller.lowestOut <= currentBuyer.highestIn){
                if (currentSeller.maxOut > currentBuyer.maxIn){
                    currentSeller.maxOut -= currentBuyer.maxIn;
                    System.out.println(currentBuyer.id + "号投资者成功购买" + currentSeller.id +
                            "号投资者" + currentBuyer.maxIn + "份股票");
                    currentBuyer.maxIn = 0;
                }
                else {
                    currentBuyer.maxIn -= currentSeller.maxOut;
                    System.out.println(currentBuyer.id + "号投资者成功购买" + currentSeller.id +
                            "号投资者" + currentSeller.maxOut + "份股票");
                    currentSeller.maxOut = 0;
                }
            }
            else
                return;
        }
    }

    public static void main(String[] args) {
        ArrayList<Investigator> investigators = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            investigators.add(new Investigator(i));
        }
        Ex22_stock stock = new Ex22_stock();
        stock.init(investigators);
        stock.trade();
    }
}
