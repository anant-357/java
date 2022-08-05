package ds;

public class Stack {

    
    public static void main(String... args){
        StackStructure head = new StackStructure();
        head.push(1);
        head.push(2);
        head.push(3);
        head.display();
        System.out.println(head.pop());
        head.display();
    }
    
}

class StackStructure{
    private class Node{
        int data;
        Node next;
    }

    Node head;

    StackStructure(){
        this.head = null;
    }

    public boolean isEmpty(){
        return head==null;
    }

    public void push(int key){
        Node temp = new Node();
        temp.data = key;
        temp.next = head;
        head = temp;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return -1;
        }
        else{
            int key = head.data;
            head = head.next;
            return key;
        }
    }

    public int top(){
        if(!isEmpty()){
            return head.data;
        }
        System.out.println("Stack is Empty");
        return -1;
    }

    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
