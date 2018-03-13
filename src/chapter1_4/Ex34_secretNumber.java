package chapter1_4;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_4
 * @Description:
 * @date 6/02/2018 10:11 AM
 */
@SuppressWarnings("SameParameterValue")
class Ex34_secretNumber {

    private final int N;
    private final int secretNum;
    private int guess;

    private Ex34_secretNumber(int n, int s){
        if (s > n) throw new IndexOutOfBoundsException();
        N = n;
        secretNum = s;
    }

    private boolean win(){
        return guess != secretNum;
    }

    private boolean guess(int g){
        int preGuess = guess;
        guess = g;
        return Math.abs(guess - secretNum) < Math.abs(preGuess - secretNum);
    }

    public static void main(String[] args) {

        Ex34_secretNumber secretNumber = new Ex34_secretNumber(100,28);

        //~2lgN
        int lo = 1;
        int hi = secretNumber.N;
        int mid;
        while (secretNumber.win()){
            mid = (hi - lo) / 2 + lo;
            secretNumber.guess(mid);
            if (secretNumber.win() && secretNumber.guess(mid+1))
                lo = mid + 1;
            else
                hi = mid - 1;
            //System.out.println(secretNumber.guess);
        }

        Ex34_secretNumber secretNumber2 = new Ex34_secretNumber(100,28);
        //~lgN
        int lo2 = 0;
        int hi2 = secretNumber2.N + 1;
        while (secretNumber2.win()){
            int mid2 = (hi2 - lo2) / 2 + lo2;
            secretNumber2.guess(mid2);
            if (hi2 - secretNumber2.secretNum > secretNumber2.secretNum - lo2)
                hi2 = mid2;
            else
                lo2 = mid2;
            System.out.println(secretNumber2.guess);
        }
    }
}
