package ca.cricri.mtc.algorithme;

public class Queues {
    private Node first;
    private Node last;
    private int length;

    public Queues(){
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    public Node peek(){
        return this.last;
    }

    public void enqueue(Node value){
        if(length == 0){
            first = value;
            last = value;
        } else {
            this.last.setNext(value);
            this.last = value;
        }
        length++;
    }

    public Node dequeue(){
        Node res = null;
        if(this.last == null) {
            System.out.println("dequeue not possible, queue empty");
        } else if(this.last == this.first) { // reference to same object in memory
            res = this.first;
            this.first = null;
            this.last = null;
            this.length--;
        } else {
            res = this.first;
            this.first = this.first.getNext();
            length--;
        }
        return res;
    }

    @Override
    public String toString(){
        return "Queue : " + this.first;
    }
}

class MainQueue{
    public static void main(String[] args) {
        Queues queue = new Queues();

        queue.enqueue(new Node(12, null));
        queue.enqueue(new Node(13, null));
        queue.enqueue(new Node(14, null));
        queue.enqueue(new Node(15, null));

        System.out.println(queue);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
    }
}
