package ds;

public class LinkedList {
    
    public static class Node{
        public int data;
        public Node next = null;

        public Node(int key){
            this.data=key;
        }

        public void push(int key){
            if(next!=null){
                next.push(key);
            }
            else{
                next = new Node(key);
            }
        }

        public void display(){
            if(this.data==-1){
                return;
            }
            System.out.print(this.data+" ");
            if(next!=null){
                next.display();
            }
            else{
                System.out.println();
            }            
            
        }

        public int pop(){
            if(this.next!=null){
                if(this.next.next!=null){
                    return this.next.pop();
                }
                else{
                    int key = this.next.data;
                    this.next = null;
                    return key;                
                }
            }
            else{
                int key = this.data;
                this.data = -1;
                return key;
            }
            
        }

        
    }

    public static void main(String... args){

        Node head = new Node(1);
        head.push(2);
        head.push(3);
        head.display();
        System.out.println(head.pop());
        head.display();
        System.out.println(head.pop());
        head.display();
        System.out.println(head.pop());
        head.display();

    }

    


    
}
