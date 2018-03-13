package chapter1_4;

import java.util.Arrays;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_4
 * @Description:
 * @date 5/02/2018 11:21 AM
 */
class Ex23_bsFraction {

    private static boolean rank(Fraction key, Fraction[] a){
        return rank(key,a,0,a.length-1);
    }
    private static boolean rank(Fraction key, Fraction[] a, int lo, int hi){
        if (lo > hi) return false;
        int mid = lo + (hi - lo) / 2;
        double N = Math.max(a[mid].denominator,key.denominator);
        double threshhold = 1 / (N * N);
        if (Math.abs(a[mid].value - key.value) < threshhold)
            return true;
        else if (a[mid].value - key.value >= threshhold)
            return rank(key,a,lo,mid-1);
        else if (key.value - a[mid].value >= threshhold)
            return rank(key,a,mid+1,hi);
        return false;
    }

    public static void main(String[] args) {

        Fraction[] fractions = {new Fraction(1,3),
                                new Fraction(2,3),
                                new Fraction(1,4),
                                new Fraction(2,5),
                                new Fraction(1,7)
        };
        Arrays.sort(fractions);
        for (Fraction fraction : fractions) System.out.println(fraction);

        System.out.println(rank(new Fraction(4,6),fractions));
        System.out.println(rank(new Fraction(1,6),fractions));
    }
}

class Fraction implements Comparable<Fraction>{

    private final double numerator;
    final double denominator;
    final double value;

    Fraction(double n, double d){
        numerator = n;
        denominator = d;
        value = n / d;
    }

    @Override
    public String toString() {
        return "(" + numerator + "/" + denominator + ")";
    }

    @Override
    public int compareTo(Fraction f) {
        return this.value - f.value > 0 ? 1 : -1;
    }
}
