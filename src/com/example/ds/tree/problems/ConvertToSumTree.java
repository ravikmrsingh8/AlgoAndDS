package com.example.ds.tree.problems;


public class ConvertToSumTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(-2);
        root.right = new Node(6);
        root.left.left = new Node(8);
        root.left.right = new Node(-4);
        root.right.left = new Node(7);
        root.right.right = new Node(5);

        System.out.println("Tree");
        Utility.levelOrderLineByLine(root);
        sumTree1(root);
        System.out.println("Sum Tree(O(N^2))");
        Utility.levelOrderLineByLine(root);

        Node root2 = sumTree2(root);
        System.out.println("Sum Tree(O(N))");
        Utility.levelOrderLineByLine(root2);

    }

    //Solution 1
    private static void sumTree1(Node root) {
        if (root == null) return;
        root.data = sum(root.left) + sum(root.right);
        sumTree1(root.left);
        sumTree1(root.right);
    }

    private static int sum(Node root) {
        if (root == null) return 0;
        else return root.data + sum(root.left) + sum(root.right);
    }


    //Solution 2
    private static Node sumTree2(Node root) {
        //TO DO
        if (root == null) return null;
        return null;
    }


}
