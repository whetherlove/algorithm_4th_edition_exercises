package chapter1_2;

import chapter1_1.Ex24_commonDivisor;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_2
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/27/027 17:37
 * @UpdateDate: 2018/1/27/027 17:37
 */
public class Ex16_rational {

    final private long numertor;
    final private long denominator;

    Ex16_rational(long n, long d){
        numertor = n;
        denominator = d;
    }

    public Ex16_rational plus(Ex16_rational b){
        long newDenominator = this.denominator*b.denominator;
        long newNumerator = this.numertor*b.denominator + this.denominator*b.numertor;
        while (!isCoprime(newDenominator,newNumerator)){
            long commonDiviosor = commonDivisor(newDenominator,newNumerator);
            newDenominator /= commonDiviosor;
            newNumerator /= commonDiviosor;
        }
        return new Ex16_rational(newNumerator,newDenominator);
    }

    public Ex16_rational minus(Ex16_rational b){
        long newDenominator = this.denominator*b.denominator;
        long newNumerator = this.numertor*b.denominator - this.denominator*b.numertor;
        while (!isCoprime(newDenominator,newNumerator)){
            long commonDiviosor = commonDivisor(newDenominator,newNumerator);
            newDenominator /= commonDiviosor;
            newNumerator /= commonDiviosor;
        }
        return new Ex16_rational(newNumerator,newDenominator);
    }

    public Ex16_rational times(Ex16_rational b){
        long newDenominator = this.denominator*b.denominator;
        long newNumerator = this.numertor*b.numertor;
        while (!isCoprime(newDenominator,newNumerator)){
            long commonDiviosor = commonDivisor(newDenominator,newNumerator);
            newDenominator /= commonDiviosor;
            newNumerator /= commonDiviosor;
        }
        return new Ex16_rational(newNumerator,newDenominator);
    }

    public Ex16_rational divides(Ex16_rational b){
        long newDenominator = this.denominator*b.numertor;
        long newNumerator = this.numertor*b.denominator;
        while (!isCoprime(newDenominator,newNumerator)){
            long commonDiviosor = commonDivisor(newDenominator,newNumerator);
            newDenominator /= commonDiviosor;
            newNumerator /= commonDiviosor;
        }
        return new Ex16_rational(newNumerator,newDenominator);
    }

    public boolean equals(Ex16_rational that){
        Ex16_rational result = this.divides(that);
        return result.denominator == 1l && result.numertor == 1l;
    }

    public String toString(){
        return numertor + "/" + denominator;
    }

    private boolean isCoprime(long newDenominator, long newNumerator) {
        return commonDivisor(newDenominator,newNumerator) == 1l;
    }

    private long commonDivisor(long p, long q) {
        if (q == 0) return p;
        long r = p % q;
        return commonDivisor(q,r);
    }
}
