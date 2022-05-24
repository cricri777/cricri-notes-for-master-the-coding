package ca.cricri.mtc.algorithme;

import java.util.Arrays;

public class Array {

    /**
     * on boucle sur les 2 tableaux, on choisit la valeur la plus petites entre les 2
     * à chaque itération.
     */
    public static int [] mergeSortedArray(int[] sortedArray1, int[] sortedArray2) {
        int i = 0, j = 0, k = 0;
        int [] mergeSortedArray = new int[sortedArray1.length + sortedArray2.length];

        while(i < sortedArray1.length && j < sortedArray2.length) {
            if(sortedArray1[i] < sortedArray2[j]) {
                mergeSortedArray[k] = sortedArray1[i];
                i++;
                k++;
            } else {
                mergeSortedArray[k] = sortedArray2[j];
                j++;
                k++;
            }
        }

        while(i < sortedArray1.length){
            mergeSortedArray[k] = sortedArray1[i];
            i++;
            k++;
        }

        while(j < sortedArray2.length){
            mergeSortedArray[k] = sortedArray2[j];
            j++;
            k++;
        }
        return mergeSortedArray;
    }

    /**
     * boucle sur le tableau de la fin au début
     * recupere les valeurs et les deposes dans l'ordre d'un nouveau tableau
     * complexité temporelle O(n)
     * complexité spatiale O(n)
     */
    public static String reverseString(String myString) {
        char[] reversedString = new char[myString.length()];

        for(int i=0; i < myString.length(); i++) {
            reversedString[myString.length()-1-i] = myString.toCharArray()[i];
        }

        return String.copyValueOf(reversedString);
    }

    /**
     * boucle sur le tableau et on reverse sur place
     * complexité temporelle O(n)
     * complexité spatiale O(n)
     */
    public static String reverseStringSurPlace(String myString) {
        char[] myStringChar = myString.toCharArray();
        for(int i=0; i < Math.floor((double)myString.length()/2); i++){
            char c = myStringChar[i];
            myStringChar[i] = myStringChar[myStringChar.length - 1 - i];
            myStringChar[myStringChar.length - 1 - i] = c;
        }

        return String.copyValueOf(myStringChar);
    }

    /**
     * twoSums link : <a href="https://leetcode.com/problems/two-sum/description/">https://leetcode.com/problems/two-sum/description/</a>
     * time complexity less than O(n^2)
     */
    public static int[] twoSum(int[] nums, int target) {
        return null;
    }



    public static void main(String[] args) {
//        System.out.println(Array.reverseStringSurPlace("blu"));
//        System.out.println(Array.reverseStringSurPlace("bonjour je m'appel cricri777"));
//        int [] sortedArray1 = {1,3,5,7,8,11,12,13,14,15};
//        int [] sortedArray2 = {2,4,6,9,10};
//
//        System.out.println(mergeSortedArray(sortedArray1, sortedArray2).length);
//        System.out.println(Arrays.toString(mergeSortedArray(sortedArray1, sortedArray2)));

        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
    }
}
