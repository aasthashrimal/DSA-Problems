/* Binary Tree Implementation
    Creating the tree
    Inorder traversal
    Preorder traversal
    Postorder traversal
    Level order traversal
*/

import java.util.*;

class Node{
    int data;
    Node left, right;
    public Node(int data){
        this.data=data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree{
    Scanner sc = new Scanner(System.in);
    Node root;

    public void createTree(){
        Queue<Node> queue = new LinkedList<>();

        System.out.print("Enter the root node value: ");
        root = new Node(sc.nextInt());
        queue.offer(root);

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print("Enter the left child of "+temp.data+" (-1 for no node): ");
            int l = sc.nextInt();
            if(l!=-1){
                temp.left = new Node(l);
                queue.offer(temp.left);
            }
            System.out.print("Enter the right child of "+temp.data+" (-1 for no node): ");
            int r = sc.nextInt();
            if(r!=-1){
                temp.right = new Node(r);
                queue.offer(temp.right);
            }
        }
    }

    public void inorder(Node node){
        if(node==null)
            return;
        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }

    public void preorder(Node node){
        if(node==null)
            return;
        System.out.print(node.data+" ");
        preorder(node.left);
        preorder(node.right);
    }

    public void postorder(Node node){
        if(node==null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data+" ");
    }
}

public class binary{
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createTree();

        System.out.println("\nInorder: ");
        bt.inorder(bt.root);

        System.out.println("\nPreorder: ");
        bt.preorder(bt.root);

        System.out.println("\nPostorder: ");
        bt.postorder(bt.root);
    }
}