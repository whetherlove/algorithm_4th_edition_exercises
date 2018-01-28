package chapter1_2;

import chapter1_3.Ex14_resizingArrayQueueOfString;
import edu.princeton.cs.algs4.In;

import java.time.LocalDate;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_2
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/27/027 15:32
 * @UpdateDate: 2018/1/27/027 15:32
 */
public class Ex11_smartDate {

    private final int year;
    private final int month;
    private final int day;

    Ex11_smartDate(int y, int m, int d) throws InvalidDateException {

        if (m > 12 || m < 1 || d > 31 || d < 1)
            throw new InvalidDateException();
        if (m == 4 || m == 6 || m == 9 || m == 11)
            if (d > 30)
                throw new InvalidDateException();
        if (this.isLeapYear() && m == 2 && d > 29)
            throw new InvalidDateException();
        if (!this.isLeapYear() && m ==2 && d > 28)
            throw new InvalidDateException();

        year = y;
        month = m;
        day = d;
    }

    Ex11_smartDate(String s) throws InvalidDateException {

        String data[] = s.split("/");
        int m = Integer.parseInt(data[0]);
        int d = Integer.parseInt(data[1]);
        int y = Integer.parseInt(data[2]);

        if (m > 12 || m < 1 || d > 31 || d < 1)
            throw new InvalidDateException();
        if (m == 4 || m == 6 || m == 9 || m == 11)
            if (d > 30)
                throw new InvalidDateException();
        if (this.isLeapYear() && m == 2 && d > 29)
            throw new InvalidDateException();
        if (!this.isLeapYear() && m ==2 && d > 28)
            throw new InvalidDateException();

        year = y;
        month = m;
        day = d;
    }

    public boolean isLeapYear(){
        if (this.year % 400 == 0)
            return true;
        else if (this.year % 100 !=0 && this.year % 4 == 0)
            return true;
        return false;
    }
    //Ex12 Zeller formula
    public String dayOfTheWeek() {

        int month = this.month;
        int year = this.year;
        if (month <= 2) {
            month += 12;
            year--;
        }
        int week = (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7;
        String[] day = {"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY"};
        return day[week];
    }

    public String toString(){
        return year + "-" + month + "-" + day;
    }



    private class InvalidDateException extends Throwable {
        public InvalidDateException() {
        }
    }
    //Exercise 1.3.16
    public static Ex11_smartDate[] readDates(String name) throws InvalidDateException {
        In in = new In(name);
        Ex14_resizingArrayQueueOfString queue =new Ex14_resizingArrayQueueOfString();
        while (!in.isEmpty())
            queue.enQueue(in.readString());
        int N = queue.size();
        Ex11_smartDate[] dates = new Ex11_smartDate[N];
        for (int i=0;i<N;i++)
            dates[i] = new Ex11_smartDate(queue.deQueue());
        return dates;
    }

    public static void main(String[] args) throws InvalidDateException {

        Ex11_smartDate smartDate = new Ex11_smartDate(1990,10,12);
        System.out.println(smartDate);

        //Ex12 test
        System.out.println(smartDate.dayOfTheWeek());
        System.out.println(LocalDate.of(1990,10,12).getDayOfWeek());

//        Ex11_smartDate wrongDate = new Ex11_smartDate(1999,21,36);
//        System.out.println(wrongDate);

    }
}
