package com.example.ds.tree.problems;

import java.util.LinkedList;
import java.util.Queue;

public class NotHavingSibling {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.left.right = new Node(6);
        System.out.println("Nodes having no sibling");
        printNodesHavingNoSibling(root);
        System.out.println();
        System.out.println("Nodes having no sibling(Rec)");
        printNodesHavingNoSiblingRec(root);
    }

    private static void printNodesHavingNoSiblingRec(Node root) {
        if(root == null) {
            return;
        } else if(root.left != null && root.right != null) {
            printNodesHavingNoSiblingRec(root.left);
            printNodesHavingNoSiblingRec(root.right);
        } else if(root.left != null) {
            System.out.print(root.left);
            printNodesHavingNoSiblingRec(root.left);
        } else if(root.right != null) {
            System.out.print(root.right);
            printNodesHavingNoSiblingRec(root.right);
        }
    }

    private static void printNodesHavingNoSibling(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            Node node = q.poll();
            if(node.left != null) {
                q.offer(node.left);
            }
            if(node.right != null ) {
                q.offer(node.right);
            }
            if(node.left == null || node.right== null) {
                if(node.left != null) System.out.print(node.left);
                if(node.right != null) System.out.print(node.right);
            }
        }
    }
}
