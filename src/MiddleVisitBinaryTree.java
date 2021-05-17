import java.util.List;
import java.util.Stack;

public class MiddleVisitBinaryTree {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree();
        root.value = "A";
        BinaryTree node = new BinaryTree();
        node.value = "B";
        root.left = node;
        node.left = null;
        BinaryTree node2 = new BinaryTree();
        node2.value = "C";
        node.right = node2;
        BinaryTree node3 = new BinaryTree();
        node3.value = "D";
        root.right = node3;
        BinaryTree node4 = new BinaryTree();
        node4.value = "E";
        node3.left = node4;
        BinaryTree node5 = new BinaryTree();
        node5.value = "F";
        node3.right = node5;
        middleVisitBinaryTree(root);
    }

    public static void middleVisitBinaryTree(BinaryTree root){
        if(root == null){
            return;
        }
        Stack<BinaryTree> binaryTreeStack = new Stack<>();
        binaryTreeStack.push(root);
        BinaryTree node = root;
        while(!binaryTreeStack.isEmpty()){

            while(node.left!=null){
                binaryTreeStack.push(node.left);
                node = node.left;
            }
            System.out.println(node.value);
            BinaryTree cur = binaryTreeStack.pop();
            if(cur.right!=null){
                binaryTreeStack.push(cur.right);
                node = cur.right;
            } else if(!binaryTreeStack.isEmpty()){
                cur = binaryTreeStack.pop();
                System.out.println(cur.value);
                if(cur.right!=null){
                    binaryTreeStack.push(cur.right);
                    node = cur.right;
                }
            }
        }

    }

    /**
     *          2
     *         / \
     */
    static class BinaryTree{
        String value;
        BinaryTree left;
        BinaryTree right;
        public BinaryTree(){

        }
    }
}
