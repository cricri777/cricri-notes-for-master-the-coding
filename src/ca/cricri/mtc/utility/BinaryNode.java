package ca.cricri.mtc.utility;

public class BinaryNode<E> {
    private final E value;
    private BinaryNode<E> leftChild;
    private BinaryNode<E> rightChild;

    public BinaryNode(E value, BinaryNode<E> left, BinaryNode<E> right) {
        this.value = value;
        this.leftChild = left;
        this.rightChild = right;
    }

    public void setRightChild(BinaryNode<E> rightChild) {
        this.rightChild = rightChild;
    }

    public void setLeftChild(BinaryNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryNode<E> getLeftChild() {
        return this.leftChild;
    }

    public BinaryNode<E> getRightChild() {
        return this.rightChild;
    }

    public E getValue(){
        return this.value;
    }

    @Override
    public String toString() {
        E leftValue =  leftChild != null ? leftChild.value : null;
        E rightValue =  rightChild != null ? rightChild.value : null;
        return "BinaryNode (value:" + value + ", leftChilValue:" + leftValue + ", rightChildValue:" + rightValue + ")";
    }
}