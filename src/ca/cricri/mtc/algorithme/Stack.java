package ca.cricri.mtc.algorithme;

import java.util.LinkedList;

public class Stack {

    java.util.LinkedList<Integer> linkedList = new LinkedList<>();

    private Integer top;
    private Integer bottom;
    private final int length;

    public Stack(){
        this.top = null;
        this.bottom = null;
        this.length = 0;
    }

    public Integer peek(){
        return this.top;
    }

    public Object pop(){
        if(!linkedList.isEmpty()){
        Integer res = linkedList.pop();

        this.top = linkedList.peek();
        return res;
        } else {
            System.out.println("stack vide");
        }
        return null;
    }

    public void push(Integer value){
        this.top = value;
        this.linkedList.push(value);
    }
}

class Blub {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(40);
        stack.push(41);
        stack.push(42);

        System.out.println("stack insert 40, 41, 42");
        System.out.println("peek [" + stack.peek() + "] shouold be 42");
        stack.pop();
        stack.pop();
        System.out.println("pop 1x");
        System.out.println("peek [" + stack.peek() + "] shouold be 40");
        stack.pop();
        stack.pop();
    }
}
