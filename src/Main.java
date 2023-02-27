
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    public List<Node> getNodesAtHeight(Node root, int height)
    {
        List<Node> nodes = new ArrayList<>();
        getNodesAtHeight(root, 0, height, nodes);
        return nodes;
    }


    private void getNodesAtHeight(Node node, int currentHeight, int targetHeight, List<Node> nodes)
    {
        if(node==null){//empty node do nothing
            return;
        }
        if(currentHeight==targetHeight){//add node to the list if current height of node equals target height
            nodes.add(node);
        }
        else if(currentHeight<targetHeight){//increment height by 1 level when calling left and right children
            getNodesAtHeight(node.left, currentHeight+1,targetHeight,nodes);
            getNodesAtHeight(node.right,currentHeight+1,targetHeight,nodes);
    }
    }
    public static boolean isMinHeap(ArrayList<Integer> minHeap)
    {
        // Traverse the max heap from the last parent to the root
            boolean isMinHeap=true;
        for(int i = ((minHeap.size()/2));i>=0;i--){//condition violates minheap proprty set boolean flag to false
            if(i*2+1<minHeap.size() && (minHeap.get(i*2+1)<minHeap.get(i) || minHeap.get(i*2+2)< minHeap.get(i))){
                isMinHeap=false;
            }
        }
        return isMinHeap;

    }
    public static boolean isBST(TreeNode T)
    {
        return isBSTHelper(T, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    public static boolean isBSTHelper(TreeNode T, int min, int max)
    {
        if(T==null){//empty node
            return true;
        }
        else if(T.left != null && (T.left.val > T.val || T.left.val < min)  || //left child is smaller than the smallest in the left tree then it violates the bst property
                T.right != null && (T.right.val < T.val || T.right.val > max)){ //right child in the left subtree is bigger than the biggest found so far from the right subtree
            return false;

        }
        else{
            return isBSTHelper(T.left,min,T.right.val) && isBSTHelper(T.right, T.left.val, max );
        }
    }
}