class Node {
    int val;
    Node left;
    Node right;
    public Node(int x){
        val=x;
    }
}
public class BST {


    public static void main(String[] args) {
        Node root = new Node(10);
        root.left= new Node(5);
        root.left.right = new Node(9);
        root.right = new Node(8);
        root.right.left = new Node(13);

        System.out.println(isBST(root));

    }
    public static boolean isBST(Node T)
    {

        return isBSTHelper(T, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static boolean isBSTHelper(Node T, int min, int max)
    {
        if(T==null){//empty node
            return true;
        }//compare left and right children with node value
        //also compare left and right children with min and max value
        else if(T.left != null && (T.left.val > T.val || T.left.val < min)  ||
                T.right != null && (T.right.val < T.val || T.right.val > max)){ //right child in the left subtree is bigger than the biggest found so far from the right subtree
            return false;

        }
        else{//when going left set max value to node (no value in the left subtree can be greater than node)
            //when going right set min value to node
            return isBSTHelper(T.left,min,T.val) && isBSTHelper(T.right, T.val, max );
        }
    }
}
