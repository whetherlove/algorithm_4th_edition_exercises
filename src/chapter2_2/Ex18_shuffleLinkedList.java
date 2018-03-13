package chapter2_2;

import java.util.LinkedList;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_2
 * @Description:
 * @date 25/02/2018 4:29 PM
 */
class Ex18_shuffleLinkedList {

    private static Comparable[] aux;

    private static void shuffle(LinkedList a){
        int N = a.size();
        aux = new Comparable[N];
        for (int size = 1; size < N; size*=2)
            for (int lo=0; lo<N-size; lo+=size+size)
                shuffle(a,lo,lo+size-1,Math.min(lo+size+size-1,N-1));
    }

    @SuppressWarnings("unchecked")
    private static void shuffle(LinkedList a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k=lo; k<=hi; k++) {
            aux[k] = (Comparable) a.get(k);
        }

        for (int k=lo; k<=hi; k++){
            if (i > mid)
                a.set(k,aux[j++]);
            else if (j > hi)
                a.set(k,aux[i++]);
            else if (Math.random()>0.5)
                a.set(k,aux[j++]);
            else
                a.set(k,aux[i++]);
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        LinkedList a = new LinkedList();
        a.add("A");
        a.add("B");
        a.add("C");
        a.add("D");
        a.add("E");
        shuffle(a);
        System.out.println(a.toString());
    }
}
