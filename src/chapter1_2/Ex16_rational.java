package chapter1_2;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_2
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/27/027 17:37
 * @UpdateDate: 2018/1/27/027 17:37
 */
class Ex16_rational {

    final private long numertor;
    final private long denominator;

    private Ex16_rational(long n, long d){

        assert d !=0;
        assert n < Long.MAX_VALUE && n > Long.MIN_VALUE;
        assert d < Long.MAX_VALUE && d > Long.MIN_VALUE;

        numertor = n;
        denominator = d;
    }

    private Ex16_rational plus(Ex16_rational b){
        long newDenominator = this.denominator*b.denominator;
        long newNumerator = this.numertor*b.denominator + this.denominator*b.numertor;
        while (isCoprime(newDenominator,newNumerator)){
            long commonDiviosor = commonDivisor(newDenominator,newNumerator);
            newDenominator /= commonDiviosor;
            newNumerator /= commonDiviosor;
        }
        return new Ex16_rational(newNumerator,newDenominator);
    }

    private Ex16_rational minus(Ex16_rational b){
        long newDenominator = this.denominator*b.denominator;
        long newNumerator = this.numertor*b.denominator - this.denominator*b.numertor;
        while (isCoprime(newDenominator,newNumerator)){
            long commonDiviosor = commonDivisor(newDenominator,newNumerator);
            newDenominator /= commonDiviosor;
            newNumerator /= commonDiviosor;
        }
        return new Ex16_rational(newNumerator,newDenominator);
    }

    private Ex16_rational times(Ex16_rational b){
        long newDenominator = this.denominator*b.denominator;
        long newNumerator = this.numertor*b.numertor;
        while (isCoprime(newDenominator,newNumerator)){
            long commonDiviosor = commonDivisor(newDenominator,newNumerator);
            newDenominator /= commonDiviosor;
            newNumerator /= commonDiviosor;
        }
        return new Ex16_rational(newNumerator,newDenominator);
    }

    private Ex16_rational divides(Ex16_rational b){
        long newDenominator = this.denominator*b.numertor;
        long newNumerator = this.numertor*b.denominator;
        while (isCoprime(newDenominator,newNumerator)){
            long commonDiviosor = commonDivisor(newDenominator,newNumerator);
            newDenominator /= commonDiviosor;
            newNumerator /= commonDiviosor;
        }
        return new Ex16_rational(newNumerator,newDenominator);
    }

    private boolean equals(Ex16_rational that){
        Ex16_rational result = this.divides(that);
        return result.denominator == 1L && result.numertor == 1L;
    }

    public String toString(){
        return numertor + "/" + denominator;
    }

    private boolean isCoprime(long newDenominator, long newNumerator) {
        return commonDivisor(newDenominator,newNumerator) != 1L;
    }

    private long commonDivisor(long p, long q) {
        if (q == 0) return p;
        long r = p % q;
        return commonDivisor(q,r);
    }

    public static void main(String[] args) {
        Ex16_rational r1 = new Ex16_rational(1,3);
        Ex16_rational r2 = new Ex16_rational(1,2);

        System.out.println(r1.plus(r2).toString());
        System.out.println(r1.minus(r2).toString());
        System.out.println(r1.times(r2).toString());
        System.out.println(r1.divides(r2).toString());
        System.out.println(r1.equals(r2));

        //Ex16_rational badR = new Ex16_rational(1,0);
//        Ex16_rational bigR = new Ex16_rational(1,Long.MAX_VALUE);
//        System.out.println(bigR.times(bigR));
    }
}
