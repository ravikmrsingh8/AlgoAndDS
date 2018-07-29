package com.example.ds.tree;

/*=========================================================
              1
            /   \
          2      3
        /  \
      4     5
     /     / \
    7     9   8

 =========================================================*/

import java.util.LinkedList;
import java.util.List;

public class FindPathInBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.left.left = new Node(7);

        root.right = new Node(3);
        root.left.right = new Node(5);
        root.left.right.left = new Node(9);
        root.left.right.right = new Node(8);

        System.out.println("Tree");
        Utility.levelOrderLineByLine(root);

        System.out.println();
        List<Node> path = findPath(root, 8);
        System.out.println("Path:"+path);

    }

    static List<Node> findPath(Node root, int data) {
        LinkedList<Node> path = new LinkedList<>();
        findPath(root, path, data);
        return path;
    }

    static boolean findPath(Node root, LinkedList<Node> path, int data) {
        if (root == null) return false;

        path.add(root);
        if (root.data == data) return true;

        boolean found = findPath(root.left, path, data) || findPath(root.right, path, data);
        if (found) {
            return true;
        } else {
            path.pollLast();
            return false;
        }
    }

}
