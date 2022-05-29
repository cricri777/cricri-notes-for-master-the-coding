package ca.cricri.mtc.algorithme;

import java.util.Arrays;

public class Sorting {

    public static int[] bubbleSort(int [] array) {
        for(int i=0; i<array.length-1; i++) {
            for(int j=0; j<array.length-1 - i; j++) {
                if(array[j] > array[j+1]) {
                    int tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return array;
    }

    public static int[] selectionSort(int [] array) {
        for(int i = 0; i < array.length; i++) {
            int min = i;
            for(int j = i; j < array.length; j++){
                // trouver min
                if(array[j] < array[min]) {
                    min = j;
                }
            }
            // swap
                int tmp = array[i];
                array[i] = array[min];
                array[min] = tmp;
        }
        return array;
    }

    /**
     * Efficace quand les données sont partiellement triés
     * <a href="https://www.geeksforgeeks.org/insertion-sort/">link</a>
     */
    public static int[] insertionSort(int [] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            /* Move elements of array[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        return array;
    }


    /**
     * <a href="https://www.baeldung.com/java-merge-sort">link</a>
     */
    public static int[] mergeSort(int[] array, int length) {
        if (length < 2) {
            return array;
        }
        int mid = length / 2;
        int[] left = new int[mid];
        int[] right = new int[length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < length; i++) {
            right[i - mid] = array[i];
        }
        mergeSort(left, mid);
        mergeSort(right, length - mid);

        return merge(array, left, right, mid, length - mid);
    }

    /**
     * <a href="https://www.baeldung.com/java-merge-sort">link</a>
     */
    public static int[] merge(
            int[] array, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                array[k++] = l[i++];
            } else {
                array[k++] = r[j++];
            }
        }
        while (i < left) {
            array[k++] = l[i++];
        }
        while (j < right) {
            array[k++] = r[j++];
        }
        return array;
    }

    public static int[] quickSort(int array) {
        return null;
    }

    public static void main(String[] args) {
        int[] array = new int[] {6,4,5,3,1,7,0};
        System.out.println(Arrays.toString(selectionSort(array)));
    }
}
