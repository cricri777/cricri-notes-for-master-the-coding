package ca.cricri.mtc.algorithme;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Map, HashMap, dictionary means the same
 * recherche : O(1)
 * insertion : majoritairement O(1) -> pire cas O(n)
 * lookup : O(1)
 * suppression : O(1)
 */
class Tuple<X, Y> {
    public final X x;
    public final Y y;
    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "Tuple(" + x + ", " + y + ")";
    }
}

public class HashTable {

    private final LinkedList<Tuple<String, Integer>>[] data;

    public HashTable(int size) {
        this.data = new LinkedList[size];
    }

    public int _hash(String key) {
        int hash = 0;
        for(int i=0; i < key.length(); i++) {
            hash = (hash + (int) key.charAt(i) * i) % this.data.length;
        }
        return hash;
    }

    private void set(String grapes, int i) {
        int address = _hash(grapes);
        Tuple<String, Integer> tuple = new Tuple<>(grapes, i);
        if(data[address] == null) {
            data[address] = new LinkedList<>();
        }
        data[address].add(tuple);
    }

    private Tuple<String, Integer> get(String grapes) {
        int address = _hash(grapes);
        for(Tuple<String, Integer> tuple : data[address]) {
            if(tuple.x.equals(grapes)) {
                return tuple;
            }
        }
        return null;
    }

    private ArrayList<Tuple<String, Integer>> keys() {
        ArrayList<Tuple<String, Integer>> result = new ArrayList<>();
        for(int i=0; i<this.data.length; i++){
            if(data[i] != null){
                for(Tuple<String, Integer> tuple : data[i]){
                    result.add(tuple);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(2);
        hashTable.set("grapes", 10000);
        hashTable.set("apples", 100);
        hashTable.set("oranges", 2000);
        System.out.println(hashTable.get("asfd"));
        System.out.println(hashTable.keys());

    }

}


class Exercices{

    /**
     * On récupère la première valeur dupliqué lorsque l'on itère dans l'ordre un tableau
     *
     * i.e : input [2,5,1,2,3,5,1] retourne 2
     *       input [2,1,1,2,3,9,6] retourne 1
     *       input [2,3,4,5] retourne null
     */
    public static Integer getFirstValueDuplicate(int[] tableau){
        HashMap<Integer, Boolean> table = new HashMap<>();

        for(int i=0; i<tableau.length; i++){
            if(table.containsKey(tableau[i])) {
                return tableau[i];
            }
            table.put(tableau[i], true);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getFirstValueDuplicate(new int[] {2,5,1,2,3,5,1}));
        System.out.println(getFirstValueDuplicate(new int[] {2,1,1,2,3,9,6}));
        System.out.println(getFirstValueDuplicate(new int[] {2,3,4,5}));
    }

}