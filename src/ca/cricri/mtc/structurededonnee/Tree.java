package ca.cricri.mtc.structurededonnee;


import ca.cricri.mtc.utility.BinaryNode;

/**
 * AVL tree / Red Black Tree
 * Binary Heap
 * Trie
 */
public class Tree {
    private BinaryNode<Integer> root;

    public Tree(int root){
        this.root = new BinaryNode<>(root, null, null);
    }

    public void insert(int value){
        BinaryNode<Integer> newValue = new BinaryNode<>(value, null, null);
        BinaryNode<Integer> current = root;
        while(true) {
            if(value < current.getValue()){
                // go left
                if(current.getLeftChild() == null) {
                    current.setLeftChild(newValue);
                    return;
                }
                current = current.getLeftChild();
            } else {
                // go right
                if(current.getRightChild() == null) {
                    current.setRightChild(newValue);
                    return;
                }
                current = current.getRightChild();
            }
        }
    }

    public BinaryNode<Integer> lookup(Integer value) {
        BinaryNode<Integer> current = root;
        while(current != null) {
           if(value < current.getValue()) {
               //go left
               current = current.getLeftChild();
           } else if(value > current.getValue()){
               //go right
               current = current.getRightChild();
           } else if(current.getValue() == value){
               //found
               return current;
           }
        }
        return null;
    }
    public static void printNode(BinaryNode<Integer> node, StringBuilder acc) {
        if(node == null) {
            return;
        }
        System.out.println(acc.append(node));

        if(node.getRightChild() != null) {
            printNode(node.getRightChild(), acc.append("right---"));
        }
        if(node.getLeftChild() != null) {
            printNode(node.getLeftChild(), acc.append("left---"));
        }
    }

    public BinaryNode<Integer> getRoot() {
        return this.root;
    }

    /**
     * TODO : compliqué
     * @param value
     */
    public void remove(int value){
    }
}

class MainTree {
    public static void main(String[] args) {
        Tree tree = new Tree(100);
        tree.insert(99);
        tree.insert(104);
        tree.insert(101);
        tree.insert(102);
//        Tree.printNode(tree.getRoot(), new StringBuilder(""));
        System.out.println(tree.lookup(104));
        System.out.println(tree.lookup(102));
        System.out.println(tree.lookup(101));
    }
}

