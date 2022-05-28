package ca.cricri.mtc.algorithme;

/**
 * Ceci n'est pas un algo (juste des notes)
 * Une fonction qui se réfère à elle même dans son implémentation
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
        if(number == 1){
            return 1;
        }
        return number * factorielRecursif(number - 1);
    }

    /**
     * TODO
     */
    public static long fiboncciIteratif(long n) {
        return -1;
    }


    /**
     * TODO
     */
    public static long fibonacciRecursif(long n) {
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(factorielRecursif(3));
//        System.out.println(factorielRecursif(4));
//        System.out.println(factorielRecursif(5));
//        System.out.println(factorielRecursif(20));

        System.out.println(fiboncciIteratif(6)); //output 8
        System.out.println(fiboncciIteratif(7)); //output 13
        System.out.println(fiboncciIteratif(8)); //output 21
        System.out.println(fiboncciIteratif(9)); //output 34
        System.out.println(fiboncciIteratif(10)); //output 55
        System.out.println(fiboncciIteratif(17)); //output 1597
    }
}
