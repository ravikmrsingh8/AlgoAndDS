package com.example.ds.tree;
/*===========================================
       45
     /    \
    35    60
   / \    /
  20  38 50

=============================================*/

import java.util.LinkedList;
import java.util.Queue;

public class CloneTree {
    public static void main(String[] args) {
        Node root = new Node(45);
        root.left = new Node(35);
        root.left.left = new Node(20);
        root.left.right = new Node(38);
        root.right = new Node(60);
        root.right.left = new Node(50);
        System.out.println("Tree");
        Utility.levelOrderLineByLine(root);
        Node root2 = clone(root);
        System.out.println("\nCloned Tree");
        Utility.levelOrderLineByLine(root2);


        Node root3 = cloneUsingQueue(root);
        System.out.println("\nCloned Tree Using Queue");
        Utility.levelOrderLineByLine(root3);

    }

    private static Node clone(Node root) {
        if(root == null) return null;
        Node leftNode = clone(root.left);
        Node rightNode = clone(root.right);
        Node newRoot = new Node(root);
        if(leftNode != null) newRoot.left = leftNode;
        if(rightNode != null)newRoot.right = rightNode;
        return newRoot;
    }

    private static Node cloneUsingQueue(Node root) {
        if(root == null) return null;
        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();
        queue1.offer(root);
        Node root2 = new Node(root);
        queue2.offer(root2);
        while(!queue1.isEmpty()) {
            Node node1 = queue1.poll();
            Node node2 = queue2.poll();
            if(node1.left != null) {
                node2.left = new Node(node1.left);
                queue1.offer(node1.left);
                queue2.offer(node2.left);
            }
            if(node1.right != null) {
                node2.right = new Node(node1.right);
                queue1.offer(node1.right);
                queue2.offer(node2.right);
            }
        }
        return root2;
    }
}
