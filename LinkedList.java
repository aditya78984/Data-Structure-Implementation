public class LinkedList{
    int m;
    public static class Node{
        int data ;
        Node next ;
        public Node(int data){
            this.data = data ;
        }
        public Node(int data, Node next){
            this.data = data;
            this.next = next ;
        }
        
    }
    public static Node head ; 
    public static Node tail ;
    public static int size ;

    public void addFirst(int data){
        Node newNode = new Node(data) ;
        size++;
        if(head == null){
            head = tail = newNode ;
            return ;
        }
        newNode.next = head ;
        head = newNode ;
    }

    public void addLast(int data){
        size++;
        Node newNode = new Node(data) ;
        if(head == null){
            head = tail = newNode ;
            return ;
        }
        tail.next = newNode ;
        tail = newNode ;
    }

    public static void print(){
        Node i = head ;
        while(i!=null){
            System.out.print(i.data + " ");
            i = i.next ;
        }
        System.out.println();
    }
    public static void print(Node head){
        Node i = head ;
        while(i!=null){
            System.out.print(i.data + " ");
            i = i.next ;
        }
        System.out.println();
    }

    public void add(int index, int data){
        Node newNode = new Node(data) ;
        if(index == 0){
            addFirst(data);
        }
        size++;
        Node temp = head ;
        int i=0;
        while( i<index-1 ){
            temp = temp.next ;
            i++ ;
        }
        newNode.next = temp.next ;
        temp.next = newNode ;
    }    
    public int valueAt(int index){
        Node temp = head ;
        for(int i=0; i<index; i++){
            temp = temp.next ;
        }
        return temp.data ;
    }
    public  int helper(Node head, int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0 ;
        }
        int index = helper(head.next, key) ;
        if(index == -1){
            return -1 ;
        }
        return index+1 ;
    }
    public int search(int key){
        return helper( head, key);
    }

    public void reverse(){
        Node prev = null ;
        Node curr = tail = head ;
        Node nextNode ;
        while(curr!=null){
            nextNode = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = nextNode ;
        }
        head = prev;
        
    }
    public int removeFirst(){
        int val = head.data ;
        head = head.next  ;
        return val ;

    }
    public int removeLastN(int pos){
        if(pos == size){
            return removeFirst() ;
        }
        Node temp = head ;
        
        for(int i=0; i<size-pos-1 ; i++){
            temp = temp.next ;
            
        }
        int val = temp.next.data ;
        temp.next = temp.next.next ;
        return val ;
    }

    public Node findMid(){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    
    public boolean checkPalindrome(){
        Node mid = findMid();
        Node prev = null ;
        Node curr = mid ;
        Node nextNode ;
        while(curr!=null){
            nextNode = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = nextNode ;

        }
        Node right = prev ; 
        Node left = head ;

        while(right!=null){
            if(left.data!=right.data){
                return false ;
            }
            right = right.next ;
            left = left.next ;
        }
        return true ;
    }

    public static boolean isCycle(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next ;
            fast = fast.next.next ;
            if(slow == fast){
                return true ;
            }
        }
        return false ;
    }

    public static void removeCycle(Node head){
        //step-1 Detect cycle
        Node slow = head ;
        Node fast = head ; 
        boolean cycle = false ; 
        while(fast!=null && fast.next!=null){
            slow = slow.next ;
            fast = fast.next.next ;
            if(slow == fast){
                cycle = true ;
                break ;
            }
        }
        if(cycle == false){
            return ;
        }
        slow = head ;
        Node prev = null ;
        while(slow!=fast){
            prev = fast ;
            slow = slow.next ;
            fast = fast.next ;
        }
        prev.next = null ;

    }

    public static Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head ;
        }
        Node mid = getMid(head);
        Node rightHead = mid.next ;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        return merge(newLeft, newRight);
    }

    private static Node getMid(Node head){
        Node slow = head ; 
        Node fast = head.next ;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow ;
    }

    private static Node merge(Node head1, Node head2){
        Node mergedLL =  new Node(-1);
        Node temp = mergedLL ;
        while(head1!=null && head2!=null){
            if(head1.data > head2.data){
                temp.next = head2 ;
                head2 = head2.next ;
                temp = temp.next ;
            }
            else{
                temp.next = head1 ;
                head1 = head1.next ;
                temp = temp.next ;
            }
        }
        while(head1!=null){
            temp.next = head1 ;
            head1 = head1.next ;
            temp = temp.next ;
        }
        while(head2!=null){
            temp.next = head2 ;
            head2 = head2.next ;
            temp = temp.next ;
        }
        return mergedLL.next ;
    }
    public static void main(String[] args) {
        // LinkedList list = new LinkedList();
        // list.addFirst(2) ;
        // list.addFirst(1) ;
        // list.addLast(3) ;
        // list.addLast(4) ;
        // list.addLast(5) ;
        // list.print();
        // list.add(2,10);
        // list.print();
        // System.out.println(list.valueAt(2));
        // System.out.println(list.search(10));
        // list.reverse();
        // System.out.println(list.removeLastN(4));
        // list.print();
        // System.out.println(list.findMid().data);
        // System.out.println(list.checkPalindrome());
        // Node head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp ;
        // temp.next = new Node(3);
        // Node temp2 = new Node(4);
        // temp.next.next = temp2 ;
        // temp2.next = temp ;
        // temp.next.next.next = null ;
        // System.out.println(isCycle(head));
        // removeCycle(head);
        // System.out.println(isCycle(head));

        Node head = new Node(5);
        Node temp = new Node(4);
        head.next = temp ;
        temp.next = new Node(3);
        Node temp2 = new Node(2);
        temp.next.next = temp2 ;
        temp2.next = new Node(1);
        print(head);
        // head = mergeSort(head);
        print(head);


    }
}