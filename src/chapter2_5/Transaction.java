package chapter2_5;

import java.time.LocalDate;
import java.util.Comparator;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_5
 * @Description: for Ex 9
 * @date 13/03/2018 3:05 PM
 */
public class Transaction {

    private LocalDate date;
    private Long amount;

    public static class WhenOrder implements Comparator<Transaction>{

        @Override
        public int compare(Transaction o1, Transaction o2) {
            return o1.date.compareTo(o2.date);
        }
    }

    public static class AmountOrder implements Comparator<Transaction>{

        @Override
        public int compare(Transaction o1, Transaction o2) {
            return o1.amount.compareTo(o2.amount);
        }
    }
}
