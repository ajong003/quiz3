import java.util.ArrayList;
import java.util.List;

class Node {
    int val;
    Node left;
    Node right;
    public Node(int x){
        val=x;
    }

    @Override
    public String toString() {
        return Integer.toString(val);
    }
}
public class BST {


    public static void main(String[] args) {
        Node root = new Node(10);
        root.left= new Node(5);
        root.right = new Node(8);
        root.left.right = new Node(9);
        root.left.left = new Node(3);
        root.left.right.left = new Node(3);
        root.right.left = new Node(13);
        root.right.right = new Node(3);


        System.out.println(isBST(root));
         List xd=getNodesAtHeight(root,2);
        System.out.println(xd.toString());

    }
    public static List<Node> getNodesAtHeight(Node root, int height)
    {
        List<Node> nodes = new ArrayList<>();
        getNodesAtHeight(root, 0, height, nodes);
        return nodes;
    }
    private static void getNodesAtHeight(Node node, int currentHeight, int targetHeight, List<Node> nodes)
    {
        if(node==null){//empty node do nothing
            return;
        }
        if(currentHeight==targetHeight){//add node to the list if current height of node equals target height
            nodes.add(node);
        }
        else {//increment height by 1 level when calling left and right children
            getNodesAtHeight(node.left, currentHeight + 1, targetHeight, nodes);
            getNodesAtHeight(node.right, currentHeight + 1, targetHeight, nodes);
        }

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
                T.right != null && (T.right.val < T.val || T.right.val > max)){
            return false;

        }
        else{//when going left set max value to node (no value in the left subtree can be greater than node)
            //when going right set min value to node
            return isBSTHelper(T.left,min,T.val) && isBSTHelper(T.right, T.val, max );
        }
    }
}
