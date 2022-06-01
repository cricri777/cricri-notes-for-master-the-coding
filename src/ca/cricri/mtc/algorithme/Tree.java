package ca.cricri.mtc.algorithme;

import ca.cricri.mtc.utility.BinaryNode;


class BinarySearchTree {

    private BinaryNode<Integer> root;

    public BinarySearchTree(BinaryNode<Integer> node) {
        this.root = node;
    }
    public BinarySearchTree(Integer value) {
        this.root = new BinaryNode<>(value, null, null);
    }

    public void insert(int value) {
        BinaryNode<Integer> nodeValue = new BinaryNode<>(value, null, null);
        BinaryNode<Integer> parentNode = this.getNodeParentPositionInTree(nodeValue);
        lookup(parentNode, new StringBuilder(""));

        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("switch");
        if(parentNode.getValue() > value) {
            nodeValue.setLeftChild(parentNode.getLeftChild());
            parentNode.setLeftChild(nodeValue);
        } else {
            nodeValue.setRightChild(parentNode.getRightChild());
            parentNode.setRightChild(nodeValue);
        }
    }

    /**
     *
     * @param nodeValue
     * @return
     */
    private BinaryNode<Integer> getNodeParentPositionInTree(BinaryNode<Integer> nodeValue) {
        BinaryNode<Integer> current = root;
        // validation condition initial
        if(current.getLeftChild() == null && current.getRightChild() == null){
            return current;
        }
        while(nodeValue.getValue() > current.getRightChild().getValue() ||
        nodeValue.getValue() < current.getLeftChild().getValue()) {
            if(nodeValue.getValue() > current.getRightChild().getValue()) {
                current = current.getRightChild();
            } else {
                current = current.getLeftChild();
            }

            if(current.getLeftChild() == null && current.getRightChild() == null){
                return current;
            }
        }
        return current;
    }

    public void lookup(BinaryNode<Integer> node, StringBuilder acc) {
        if(node != null) {
            System.out.println(acc.toString() + node);
            acc.append("----");
            if(node.getLeftChild() != null) {
                this.lookup(node.getLeftChild(), acc);
            }
            if(node.getRightChild() != null) {
                this.lookup(node.getRightChild(), acc);
            }
        }
    }
}



class MainTree {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree(1);

        binarySearchTree.insert(2);
    }
}