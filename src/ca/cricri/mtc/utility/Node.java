package ca.cricri.mtc.utility;

public class Node<E> {
    private E value;
    private Node<E> next;

    public Node(E value, Node<E> next) {
        this.value = value;
        this.next = next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
    public Node<E> getNext() {
        return this.next;
    }

    @Override
    public String toString() {
        return "Node(" + value + ", " + next + ")";
    }
}