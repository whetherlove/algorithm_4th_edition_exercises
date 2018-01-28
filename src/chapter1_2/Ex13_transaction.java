package chapter1_2;

import chapter1_3.Ex14_resizingArrayQueueOfString;
import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.In;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_2
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/27/027 16:28
 * @UpdateDate: 2018/1/27/027 16:28
 */
public class Ex13_transaction implements Comparable<Ex13_transaction>{

    final private String who;
    final private Date when;
    final private double amount;

    Ex13_transaction(String w, Date d, double a){
        who = w;
        when = d;
        amount = a;
    }

    Ex13_transaction(String s){
        String[] data = s.split(" ");
        who = data[0];
        when = new Date(data[1]);
        amount = Double.parseDouble(data[2]);
    }

    public String who(){
        return who;
    }

    public Date when(){
        return when;
    }

    public double amount(){
        return amount;
    }

    public String toString(){
        return who + " " + when + " " + amount;
    }

    public boolean equals(Object that){
        return this.getClass().equals(that.getClass()) &&
                this.who.equals(((Ex13_transaction)that).who) &&
                this.when.equals(((Ex13_transaction) that).when) &&
                this.amount == ((Ex13_transaction)that).amount;
    }

    //Exercise 1.3.17
    public static Ex13_transaction[] readDates(String name) {
        In in = new In(name);
        Ex14_resizingArrayQueueOfString queue =new Ex14_resizingArrayQueueOfString();
        while (!in.isEmpty())
            queue.enQueue(in.readString());
        int N = queue.size();
        Ex13_transaction[] t = new Ex13_transaction[N];
        for (int i=0;i<N;i++)
            t[i] = new Ex13_transaction(queue.deQueue());
        return t;
    }

    @Override
    public int compareTo(Ex13_transaction o) {

        if (this.who.compareTo(o.who) != 0)
            return this.who.compareTo(o.who);
        else if (this.when.compareTo(o.when) != 0)
            return this.when.compareTo(o.when);
        return String.valueOf(this.amount).compareTo(String.valueOf(o.amount));

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
