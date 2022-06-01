package ca.cricri.mtc.algorithme;

import ca.cricri.mtc.structurededonnee.BinaryTree;
import ca.cricri.mtc.utility.BinaryNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Searching {

    /**
     * linear search
     * binary search
     * tree traversal / graph traversal = (BFS / DFS)
     *  - pourquoi les utiliser ?
     *    - BFS
     *      - timecomplexity O(n)
     *      - spacecomplexity O(n) need to hold all vertice in a queue
     *      - shortest path ou closer nodes
     *      - more memory
     *    - DFS :
     *      - timecomplexity O(n)
     *      - spacecomplexity O(h) in recursion with h depth of the tree
     *                        O(n) in iterative as BFS but use stack instead of queue
     *      - less memory (does path exist ?)
     *      - can get slow
     *
     * Pour DFS : 3 facon d'itérer :
     *
     * i.e :         9
     *          4         20
     *       1    6    15    170
     *
     *  - PreOrder : [9, 4, 1, 6, 20, 15, 170]
     *  - InOrder : [1,4,6,9,15,20,170]
     *  - PostOrder : [1,6,4,15,170,20,9]
     *
     * interview question example :
        - If you know a solution is not far from the root of the tree: BFS
         - If the tree is very deep and solutions are rare : BFS (DFS will take long time)
        - If the tree is very wide: DFS (BFS will need too much memory)
        - If solutions are frequent but located deep in the tree : DFS
        - Determining whether a path exists between two nodes : DFS
        - Finding the shortest path : BFS
     */

    public static List<Integer> bfs(BinaryTree binaryTree) {
        BinaryNode<Integer> currentNode = binaryTree.getRoot();
        List<Integer> result = new ArrayList<>();
        Queue<BinaryNode<Integer>> queue = new LinkedList<>();

        queue.add(currentNode);
        while(queue.size() > 0){
            currentNode = queue.poll();
            result.add(currentNode.getValue());
            if(currentNode.getLeftChild() != null) {
                queue.add(currentNode.getLeftChild());
            }
            if(currentNode.getRightChild() != null) {
                queue.add(currentNode.getRightChild());
            }
        }
        return result;
    }

    public static List<Integer> bfsRecursive(Queue<BinaryNode<Integer>> queue, ArrayList<Integer> result) {
        if(queue.isEmpty()) {
            return result;
        }

        BinaryNode<Integer> currentNode = queue.poll();
        result.add(currentNode.getValue());
        if(currentNode.getLeftChild() != null) {
            queue.add(currentNode.getLeftChild());
        }
        if(currentNode.getLeftChild() != null) {
            queue.add(currentNode.getRightChild());
        }


        return bfsRecursive(queue, result);
    }
}

class MainSearching {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(9);
        tree.insert(4);
        tree.insert(6);
        tree.insert(20);
        tree.insert(170);
        tree.insert(15);
        tree.insert(1);

//        BinaryTree.printNode(tree.getRoot(), new StringBuilder(""));

//        System.out.println(Searching.bfs(tree));
        Queue<BinaryNode<Integer>> queue = new LinkedList<>();
        queue.add(tree.getRoot());
        System.out.println(Searching.bfsRecursive(queue, new ArrayList<Integer>()));

    }

}