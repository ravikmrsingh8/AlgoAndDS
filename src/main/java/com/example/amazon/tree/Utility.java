package com.example.amazon.tree;


import java.util.LinkedList;
import java.util.Queue;

public class Utility {
    public static void levelOrderLineByLine(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == null) {
                System.out.println();
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            } else {
                System.out.print((node)+"\t");
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
    }
}
