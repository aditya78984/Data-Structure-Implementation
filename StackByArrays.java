public class StackByArrays {
    static class Stack{
        int size ;
        int top = -1 ;
        int[] arr ;
        Stack(int size){
            this.size = size ;
            arr = new int[size];
        }
        
        boolean isEmpty(){
            return top==-1;
        }
        boolean isFull(){
            return top==size;
        }
        void push(int data){
            if(isFull()){
                System.out.println("stack is full");
            }
            top++;
            arr[top] = data ;
            
        }
        int pop(){
            if(isEmpty()){
                System.out.println("stack is empty");
                return -1 ;
            }
            int val = arr[top] ;
            top-- ;
            return val;
        }
        int peek(){
            if(isEmpty()){
                System.out.println("stack is empty");
                return -1 ;
            }
            return arr[top];
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack(5);
        System.out.println(s.isEmpty());
        System.out.println(s.isFull());
        s.push(1);
        s.push(2);
        s.push(3);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }


    }
}
