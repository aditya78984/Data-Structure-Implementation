

public class BalanceBST {
    public static class Node{
        int data;
        Node left;
        Node right ;
        Node(int data){
            this.data = data;
        }
    }
    public static Node deleteLeafX( Node root, int x){
        if(root == null){
            return root;
        }
        if(root.left==null && root.right==null && root.data == x){
            return null;
        }
        root.left = deleteLeafX(root.left, x);
        root.right = deleteLeafX(root.right, x);
        return root;
    }
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(12);
        root.right = new Node(5);
        root.left.right = new Node(3);
        root.left.left = new Node(22);
        root.right.left = new Node(3);
        root = deleteLeafX(root, 3);
        inorder(root);
    }
}
