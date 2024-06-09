public class StackLinkedList {
    private static class Node{
        int data ;
        Node next ;
        Node(int data){
            this.data = data;
            this.next = null ;
        }
    }
    public static class Stack{
        static Node head = null;
        public static boolean isEmpty(){
            return head == null ;
        }
        public static void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                return ;
            }
            newNode.next = head;
            head = newNode ;

        }
        public static int pop(){
            if(isEmpty()){
                System.out.println("Empty stack");
                return -1;
            }
            int val = head.data ;
            head = head.next;
            return val ;

        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Empty stack");
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
        System.out.println(s.pop());
    }
}
