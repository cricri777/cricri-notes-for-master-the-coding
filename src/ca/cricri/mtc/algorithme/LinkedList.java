package ca.cricri.mtc.algorithme;

import ca.cricri.mtc.algorithme.utility.Node;

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
    private Node<String> head;
    private Node<String> tail;
    private long length;

    public LinkedList(int headValue){
        this.head = new Node(headValue, null);
        this.tail = this.head;
        this.length = 1;
    }

    public void append(String value) {
        Node<String> node = new Node<String>(value, null);
        this.tail.setNext(node);
        this.tail = node;
        this.length++;
    }

    public void insert(int index, String value) {
        if(index < 0 || index >= this.length){
            throw new IndexOutOfBoundsException("index [" + index + "] n'est pas valide");
        }
        if(index == 0){
            prepend(value);
        }
        if(index == this.length-1){
            append(value);
        }

        Node<String> node = new Node<>(value, null);
        Node<String> currentNode = head;
        for(int i=0; i<index-1; i++) {
            currentNode = currentNode.getNext();
        }

        node.setNext(currentNode.getNext());
        currentNode.setNext(node);
        this.length++;
    }

    // TODO : implement prepend
    public void prepend(String value) {
        Node<String> node = new Node<>(value, head);
        node.setNext(head);
        head = node;
        this.length++;
    }

    @Override
    public String toString() {
        return "linkedListSize:[" + this.length + "],  linkedList" + head.toString();
    }
}



class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(100);
        linkedList.append("101");
        linkedList.append("102");
        linkedList.append("103");
        System.out.println(linkedList);
        linkedList.append("104");
        System.out.println(linkedList);
//        linkedList.prepend(31);
        linkedList.prepend("32");
        linkedList.prepend("33");
        System.out.println(linkedList);
        linkedList.append("12143");
        System.out.println(linkedList);
        linkedList.insert(7, "4734956");
        System.out.println(linkedList);
    }
}