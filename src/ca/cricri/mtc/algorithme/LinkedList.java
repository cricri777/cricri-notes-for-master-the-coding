package ca.cricri.mtc.algorithme;

/**
 * Liste Chainee
 * Complexité temporelle
 * prepend O(1)
 * append O(1)
 * lookup O(1)
 * insert O(n)
 * delete O(n)
 */
public class LinkedList {
    private Node head;
    private Node tail;
    private long length;

    public LinkedList(int headValue){
        this.head = new Node(headValue, null);
        this.tail = this.head;
        this.length = 1;
    }

    public void append(int value) {
        Node node = new Node(value, null);
        this.tail.setNext(node);
        this.tail = node;
    }

    // TODO : implement prepend
    public void prepend(int value) {

    }
    @Override
    public String toString() {
        return "tail: " + tail.toString() + ", head:" + head.toString();
    }
}

class Node {
    private long value;
    private Node next;

    public Node(long value, Node next) {
        this.value = value;
        this.next = next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node(" + value + ", " + next + ")";
    }
}

class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(100);
        linkedList.append(101);
        linkedList.append(102);
        linkedList.append(103);
        System.out.println(linkedList);
        linkedList.append(104);
        System.out.println(linkedList);
    }
}