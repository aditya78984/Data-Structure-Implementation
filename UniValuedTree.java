public class UniValuedTree {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }

    }
    public static boolean isUniValued(Node root){
       
        if(root == null){
            return true;
        }
        
        if(root.left!=null && root.left.data != root.data  ){
            
                return false;
            
        }
        if(root.right!=null && root.right.data != root.data){
            
                return false;
            
        }
        
        return isUniValued(root.left) && isUniValued(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.right = new Node(2);
        root.left.left = new Node(2);
        root.right.left = new Node(5);
        System.out.println(isUniValued(root));

    }
}
