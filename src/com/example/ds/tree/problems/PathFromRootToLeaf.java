package com.example.ds.tree.problems;
/*===========================================
        45         Paths
     /     \       45->35->20
    35     60      45->35->38->36
   / \     /       45->35->38->40
  20  38  50       45->60->50
     /  \
    36   40
=============================================*/

import java.util.LinkedList;

public class PathFromRootToLeaf {
    public static void main(String[] args) {
        Node root = new Node(45);
        root.left = new Node(35);
        root.left.left = new Node(20);
        root.left.right = new Node(38);
        root.left.right.right = new Node(40);
        root.left.right.left = new Node(36);
        root.right = new Node(60);
        root.right.left = new Node(50);
        System.out.println("Tree");
        Utility.levelOrderLineByLine(root);

        System.out.println("\nAll Paths");
        printPaths(root);

    }

    private static void printPaths(Node root) {
        LinkedList<Node> nodes = new LinkedList<>();
        printPaths(root,nodes);
    }

    private static void printPaths(Node root, LinkedList<Node> nodes) {

    }
}
