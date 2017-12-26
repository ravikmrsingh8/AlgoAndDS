package com.example.ds.tree.bst;
/*=================================================================
            45
        /       \
       30       70
     /   \     /
    20   40   60
             /
            55
===================================================================*/

import com.example.ds.tree.problems.Node;
import com.example.ds.tree.problems.Utility;

public class BST {
    public static void main(String[] args) {
        Node root = null;

        root = insert(root, 45);
        root = insert(root, 70);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 20);
        root = insert(root, 60);
        root = insert(root, 55);
        Utility.levelOrderLineByLine(root);
        System.out.println("Found 20:" + search(root, 20));
        System.out.println("Found 50:" + search(root, 50));
        System.out.println("Found 55:" + search(root, 55));
        System.out.println("Delete 60");
        root = delete(root, 60);
        Utility.levelOrderLineByLine(root);
        System.out.println("Delete 45");
        root = delete(root, 45);
        Utility.levelOrderLineByLine(root);
        System.out.println("Delete 40");
        root = delete(root, 40);
        Utility.levelOrderLineByLine(root);

    }

    public static Node insert(Node root, int data) {
        Node newNode = new Node(data);
        if (root == null) return newNode;
        else if (data < root.data) root.left = insert(root.left, data);
        else root.right = insert(root.right, data);
        return root;
    }

    public static boolean search(Node root, int key) {
        if (root == null) return false;
        else if (root.data == key) return true;
        else if (key < root.data) return search(root.left, key);
        else return search(root.right, key);
    }

    public static Node delete(Node root, int key) {
        if (root == null) {
            return null;
        } else if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                //Leaf DNode
                return null;
            } else if (root.left == null) {
                //Left subtree is null, so return right subtree root
                return root.right;
            } else if (root.right == null) {
                //Right subtree is null,so return left subtree root
                return root.left;
            } else {
                //Get Inorder Successor
                Node nextNode = inOrderSuccessor(root);
                root.data = nextNode.data;
                root.right = delete(root.right, nextNode.data);
            }
        }
        return root;
    }

    private static Node inOrderSuccessor(Node root) {
        if (root == null) return null;
        Node currNode = root.right;
        while (currNode.left != null) {
            currNode = currNode.left;
        }
        return currNode;
    }
}
