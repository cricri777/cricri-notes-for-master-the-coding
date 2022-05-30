package ca.cricri.mtc.algorithme;

import java.util.ArrayList;
import java.util.List;

public class Tree {

}

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

class BinaryNode<E> {


    private final E value;
    private BinaryNode<E> leftChild;
    private BinaryNode<E> rightChild;

    public BinaryNode(E value, BinaryNode<E> leftChild, BinaryNode<E> rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public E getValue(){
        return this.value;
    }
    public BinaryNode<E> getLeftChild() {
        return this.leftChild;
    }

    public BinaryNode<E> getRightChild() {
        return this.rightChild;
    }

    public BinaryNode<E>[] getChildren() {
        @SuppressWarnings("unchecked")
        BinaryNode<E>[] children = new BinaryNode[2];
        children[0] = this.getLeftChild();
        children[1] = this.getRightChild();
        return children;
    }

    public void setLeftChild(BinaryNode<E> leftChild) {
        this.leftChild = leftChild;
    }
    public void setRightChild(BinaryNode<E> rightChild) {
        this.rightChild = rightChild;
    }

    /**
     *
     * @param children tableau qui contient les enfant (position 0 enfant gauche, position 1 enfant droite)
     */
    public void setChildren (BinaryNode<E>[] children) {
        this.setLeftChild(children[0]);
        this.setRightChild(children[1]);
    }

    @Override
    public String toString() {
        return "BinaryNode (value:" + this.getValue() + " , left:" + this.getLeftChild().getValue() + ", right:" + this.getRightChild().getValue() + ")";
    }
}


class MainTree {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree(1);

        binarySearchTree.insert(2);
    }
}