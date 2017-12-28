package com.example.ds.tree.bst;
/*=================================================================
            45
        /       \
       30       70
     /   \     /  \
    20   40   60   80
             /
            55
===================================================================*/


import com.example.ds.tree.problems.Node;
import com.example.ds.tree.problems.Utility;

public class LCA {
    public static void main(String[] args) {
        Node root = null;

        root = insert(root, 45);
        root = insert(root, 70);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 20);
        root = insert(root, 60);
        root = insert(root, 55);
        root = insert(root, 80);
        System.out.println("Tree");
        Utility.levelOrderLineByLine(root);
        System.out.println("LCA(55, 80)" + lca(root, 55, 80));
        System.out.println("LCA(55, 40)" + lca(root, 55, 40));
        System.out.println("LCA(40, 55)" + lca(root, 40, 55));
        System.out.println("LCA(40, 90)" + lca(root, 40, 90));
        System.out.println("LCA(99, 90)" + lca(root, 99, 90));
    }

    static Node lca(Node root, int a, int b) {
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }

        return findLCA(root, a, b);
    }

    static Node findLCA(Node root, int a, int b) {
        if (root == null) return null;
        else if (root.data > a && root.data > b) return findLCA(root.left, a, b);
        else if (root.data < a && root.data < b) return findLCA(root.right, a, b);
        else {
            // this node is lca if both a and b are present
            if (search(root, a) && search(root, b)) return root;
            else return null;

        }
    }

    static boolean search(Node root, int data) {
        while (root != null) {
            if (root.data == data) return true;
            else if (root.data > data) root = root.left;
            else root = root.right;
        }
        return false;
    }

    static Node insert(Node root, int data) {
        if (root == null) root = new Node(data);
        else if (data > root.data) root.right = insert(root.right, data);
        else root.left = insert(root.left, data);
        return root;
    }
}
