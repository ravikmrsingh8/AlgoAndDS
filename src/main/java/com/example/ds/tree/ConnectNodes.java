package com.example.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodes {
    public static void main(String[] args) {
        NNode root = new NNode(45);
        root.left = new NNode(35);
        root.left.left = new NNode(20);
        root.left.right = new NNode(38);
        root.right = new NNode(60);
        root.right.left = new NNode(50);
        System.out.println("Tree");
        Utility.levelOrderLineByLine(root);

        System.out.println("\nAfter Connecting Next Nodes");
        connect(root);
        Utility.levelOrderLineByLine(root);
    }

    static void connect(NNode root) {
        if(root == null) return;
        Queue<NNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()) {
            NNode node = q.poll();
            if(node == null) {
                if(!q.isEmpty()){
                    q.offer(null);
                }
            } else {
                node.next = q.peek();
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
        }
    }
}
