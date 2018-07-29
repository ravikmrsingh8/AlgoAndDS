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

public class HeightOfATree {
    public static void main(String[] args) {
        Node root = new Node(45);
        root.left = new Node(35);
        root.left.left = new Node(20);
        root.left.right = new Node(38);
        root.right = new Node(60);
        root.right.left = new Node(50);
        System.out.println("Tree");
        Utility.levelOrderLineByLine(root);
        int height = height(root);
        System.out.println("Height of tree: " + height);

        System.out.println("\nTree");
        Utility.levelOrderLineByLine(root);
        height = iterativeHeight(root);
        System.out.println("Height of tree(I): " + height);
    }

    private static int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private static int iterativeHeight(Node root) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        int height = 1;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == null) {
                if (!queue.isEmpty()) {
                    height++;
                    queue.offer(null);
                }
            } else {
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return height;
    }
}