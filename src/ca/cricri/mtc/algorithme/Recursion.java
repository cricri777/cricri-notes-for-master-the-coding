package ca.cricri.mtc.algorithme;

/**
 * Pourquoi utiliser un fonction recursive au lieu d'iterative ?
 * pour :
 *  - DRY
 * contre :
 *  - Large Stack Memory
 *  - i.e fibonacci recursion O(2^n) vs iteratif O(n)
 *
 * good application : Merge sort, Quick sort, Tree traversal, Graph traversal
 */
public class Recursion {

    public static long factorielIteratif(long number) {
        if(number < 0) {
            System.out.println("juste nombre positif");
            return -1;
        }
        long resultat = 1;
        for(int i=1; i <= number; i++) {
            resultat *= i;
        }
        return resultat;
    }

    public static long factorielRecursif(long number) {
        if(number == 1) {
            return 1;
        }
        return number * factorielRecursif(number - 1);
    }

    public static long fiboncciIteratif(long n) {
        long premierNumero = 0;
        long deuxNumero = 1;
        int i = 1;
        while(i < n){
            long tmp = deuxNumero;
            deuxNumero = premierNumero + deuxNumero;
            premierNumero = tmp;
            i++;
        }
        return deuxNumero;
    }


    public static long fibonacciRecursif(long n) {
        if(n < 2) {
            return n;
        }
        return fibonacciRecursif(n-1) + fibonacciRecursif(n-2);
    }

    public static String reverseString(String sentence){
        if(sentence.equals("")) {
            return "";
        }
        return reverseString(sentence.substring(1)) + sentence.charAt(0);
    }


    public static void main(String[] args) {
        System.out.println(reverseString("hello cricri"));
    }
}
