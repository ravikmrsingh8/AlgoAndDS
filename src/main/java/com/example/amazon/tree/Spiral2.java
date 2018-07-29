package com.example.amazon.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Spiral2 {

    public static void main(String[] args) {
        Node root  = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        printSpiral(root);
    }
    static void printSpiral(Node root)  {
        // Your code here
        if(root == null) return;
        LinkedList<Node> nodes = new LinkedList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        int level = 0;
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node == null) {
                if(!q.isEmpty()){
                    q.offer(null);
                }
                printNodesAtLevel(nodes,level);
                level++;
                continue;
            }
            nodes.add(node);
            if(node.left != null)q.offer(node.left);
            if(node.right != null)q.offer(node.right);

        }
    }

    static void printNodesAtLevel(LinkedList<Node> nodes, int level) {
        if(level % 2 == 0) {
            while(!nodes.isEmpty()){
                System.out.print(nodes.pollLast().data+" ");
            }
        } else {
            while(!nodes.isEmpty()){
                System.out.print(nodes.pollFirst().data+" ");
            }
        }
    }
}
