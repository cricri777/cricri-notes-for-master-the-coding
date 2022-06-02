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
        while(queue.size() > 0) {
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

    public static List<Integer> dfsPostOrder(BinaryTree tree) {
        return traversePostOrder(tree.getRoot() , new ArrayList<Integer>());
    }

    private static List<Integer> traversePostOrder(BinaryNode<Integer> current, ArrayList<Integer> results) {
        System.out.println("traverse node : " + current.getValue());
        if(current.getLeftChild() != null) {
            traversePostOrder(current.getLeftChild(), results);
        }
        if(current.getRightChild() != null) {
            traversePostOrder(current.getRightChild(), results);
        }
        System.out.println("pick node : " + current.getValue());
        results.add(current.getValue());
        return results;
    }

    public static List<Integer> dfsInOrder(BinaryTree tree) {
        ArrayList<Integer> results = new ArrayList<>();
        return traverseInOrder(tree.getRoot(), results);
    }

    private static ArrayList<Integer> traverseInOrder(BinaryNode<Integer> current, ArrayList<Integer> results) {
        System.out.println("traverse node : " + current.getValue());
        if(current.getLeftChild() != null) {
            traverseInOrder(current.getLeftChild(), results);
        }
        System.out.println("pick node : " + current.getValue());
        results.add(current.getValue());
        if(current.getRightChild() != null) {
            traverseInOrder(current.getRightChild(), results);
        }
        return results;
    }

    public static List<Integer> dfsPreorder(BinaryTree tree) {
        return traversePreOrder(tree.getRoot(), new ArrayList<Integer>());
    }

    private static List<Integer> traversePreOrder(BinaryNode<Integer> current, ArrayList<Integer> results) {
        System.out.println("traverse node : " + current.getValue());
        System.out.println("pick node : " + current.getValue());
        results.add(current.getValue());
        if(current.getLeftChild() != null) {
            traversePreOrder(current.getLeftChild(), results);
        }
        if(current.getRightChild() != null) {
            traversePreOrder(current.getRightChild(), results);
        }
        return results;
    }


    public static void main(String[] args) {

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

        System.out.println(Searching.dfsPostOrder(tree));
    }
}


/**
 * TODO :
 * <a href="https://leetcode.com/problems/validate-binary-search-tree/">link</a>
  Definition for a binary tree node.
 */
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  class Solution {
      /**
       * Algo :
       * - parcourir les noeuds de l'arbre
       * - si le noeud a des enfants, valider :
       *    - l'enfant gauche est toujours plus petit que le parent
       *    - l'enfant droit est toujours plus grand que le parent
       * @param root Treenode to iterate
       * @return boolean true if tree is a Binary Search Tree
       * <a href="https://leetcode.com/problems/validate-binary-search-tree/">leetcode</a>
       * inspired by : <a href="https://leetcode.com/problems/validate-binary-search-tree/discuss/2100305/Java-Recursion-Solution">link</a>
       */
      public boolean isValidBST(TreeNode root) {
          return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
      }

      private boolean isValidBSTHelper(TreeNode current, long leftChild, long rightChild) {
          if(current == null) {
              return true;
          }
          if(current.val > leftChild && current.val < rightChild) {
              return isValidBSTHelper(current.left, leftChild, current.val) &&
                      isValidBSTHelper(current.right, current.val, rightChild);
          }
          return false;
      }
  }


