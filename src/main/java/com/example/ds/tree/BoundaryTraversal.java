package com.example.ds.tree;

/*===========================================
        45
     /     \
    35     60
   / \     /
  20  38  50
     /  \
    36   40
=============================================*/

public class BoundaryTraversal {
    Node root;
    BoundaryTraversal(){
        root = new Node(45);
        root.left = new Node(35);
        root.left.left = new Node(20);
        root.left.right = new Node(38);
        root.left.right.right = new Node(40);
        root.left.right.left = new Node(36);
        root.right = new Node(60);
        root.right.left = new Node(50);
    }
    public static void main(String[] args) {
        BoundaryTraversal traversal = new BoundaryTraversal();
        System.out.println("Tree");
        Utility.levelOrderLineByLine(traversal.root);

        System.out.println();
        traversal.boundaryTraversal();
    }

    public void boundaryTraversal(){
        if(root == null) return ;
        boundaryTraversal(root);
    }
    private void boundaryTraversal(Node root){
        System.out.print(root+" ");
        printLeft(root.left);
        printLeaf(root);
        printRight(root.right);
    }

    void printLeft(Node root){
        if(root == null  || isLeaf(root)) return;
        System.out.print(root+" ");
        if(root.left != null) printLeft(root.left);
        else if(root.right != null) printLeft(root.right);
    }

    void printLeaf(Node root){
        if(root == null) return;
        if(isLeaf(root)) System.out.print(root+" ");
        printLeaf(root.left);
        printLeaf(root.right);
    }

    void printRight(Node root){
        if(root == null || isLeaf(root)) return;

        if(root.right != null)printRight(root.right);
        else if(root.left != null)printRight(root.left);
        System.out.print(root+ " ");
    }

    static boolean isLeaf(Node root){
        return root.left == null && root.right == null;
    }
}
