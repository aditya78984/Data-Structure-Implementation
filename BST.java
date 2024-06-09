public class BST {
    static class Node{
        int data;
        Node right;
        Node left;
        Node(int val){
            this.data = val ;
            this.left = null;
            this.right = null;
        }
    }
    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(val > root.data){
            root.right = insert(root.right, val);
        }
        if(val < root.data){
            root.left = insert(root.left, val);
        }
        return root;
    }
    public static boolean search(Node root, int val){
        if(root == null){
            return false;
        }
        if(root.data == val){
            return true;
        }
        else if(root.data > val){
            return search(root.left, val);
        }
        else{
            return search(root.right, val);

        }
    }

    public static Node delete(Node root, int val){
        if(root.data > val){
            root.left = delete(root.left, val);
        }
        else if(root.data < val){
            root.right = delete(root.right, val);
        }
        else{
            // case 1 - no child
            if(root.left == null && root.right == null){
                return null;
            }

            // case 2 - 1 child
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            // case 3 - 2 child
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }
    public static Node findInorderSuccessor(Node root){
        // if(root == null){
        //     return root ;
        // }
        while(root.left!=null){
            root = root.left ;
        }
        return root;
    }
    public static Node findInorderPredecessor(Node root){
        // if(root == null){
        //     return root ;
        // }
        while(root.right!=null){
            root = root.right ;
        }
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
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void postorder(Node root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
        
    }
    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return ;
        }
        if(root.data >= k1 && root.data <= k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data < k1){
            printInRange(root.right, k1, k2);
        }
        else{
            printInRange(root.left, k1, k2);
        }
    }
    public static boolean isBST(Node root){
        if(root.left == null && root.right == null){
            return true;
        }
        
        Node p = root.left==null ? root : findInorderPredecessor(root.left) ;
        Node s = root.right==null ? root : findInorderSuccessor(root.right);
        System.out.println(p.data + " " + s.data + " " + root.data);
        if(p.data > root.data || root.data > s.data){
            return false ;
        }
        if(root.left == null){
            return true;
        }
        else if(root.right == null){
            return true;
        }
        boolean left = isBST(root.left);
        boolean right = isBST(root.right);

        
        return left && right ;
    }
    public static Node arrToBST( int[] arr, int start, int end){
        int mid = (start + end)/2;
        
        if(start > end){
            return null;
        } 
        Node root = new Node(arr[mid]);
        root.left = arrToBST(arr, start, mid-1);
        root.right = arrToBST(arr, mid+1, end);
        return root;
    }
    public static void main(String[] args) {
        // int[] values = {5,1,3,4,2,7};
        // Node root = null;
        // for (int i = 0; i < values.length; i++) {
        //     root = insert(root, values[i]);
        // }
        // inorder(root);
        // System.out.println();
        // preorder(root);
        // System.out.println();
        // postorder(root);
        // System.out.println();

        // System.out.println(search(root,6));;
        // root=delete(root, 3);
        // inorder(root);
        // System.out.println();
        // printInRange(root, 2, 8);
        // System.out.println();


        // Node root = new Node(5);
        // root.left = new Node(3);
        // root.left.left = new Node(1);
        // root.left.right = new Node(4);
        // root.right = new Node(7);
        // root.right.right = new Node(8);
        
        // boolean ans = isBST(root);
        // System.out.println(ans);

        int[] arr = {1,2,3,4,5,6,7};              
        
        Node root = arrToBST(arr, 0, arr.length-1);
        preorder(root);
    }
}   
