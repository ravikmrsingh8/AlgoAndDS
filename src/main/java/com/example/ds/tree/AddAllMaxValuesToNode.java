package com.example.ds.tree;
/*=================================================================
            10
        /       \
       3         12
     /   \         \
    2     4        16
                  /  \
                14   20
                 \
                 15
===================================================================*/

public class AddAllMaxValuesToNode {
    static int sum = 0;
    public static void main(String[] args) {
        Node root = null;

        root = insert(root, 10);
        root = insert(root, 12);
        root = insert(root, 3);
        root = insert(root, 4);
        root = insert(root, 2);
        root = insert(root, 16);
        root = insert(root, 20);
        root = insert(root, 14);
        root = insert(root, 15);
        Utility.levelOrderLineByLine(root);
        System.out.println("\n");
        convert(root);
        Utility.levelOrderLineByLine(root);
    }

    public static Node insert(Node root, int data) {
        Node newNode = new Node(data);
        if (root == null) return newNode;
        else if (data < root.data) root.left = insert(root.left, data);
        else root.right = insert(root.right, data);
        return root;
    }

    static void convert(Node root){
        if(root == null) return;
        convert(root.right);
        sum += root.data;
        root.data = sum;
        convert(root.left);
    }
}
