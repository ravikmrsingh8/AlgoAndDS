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

import java.util.LinkedList;
import java.util.List;

public class FindPathInBST {
    public static void main(String[] args) {
        Node root = null;

        root = add(root, 45);
        root = add(root, 70);
        root = add(root, 30);
        root = add(root, 40);
        root = add(root, 20);
        root = add(root, 60);
        root = add(root, 55);
        System.out.println("Tree:");
        Utility.levelOrderLineByLine(root);

        System.out.println("Path(55)"+findPath(root, 55));
        System.out.println("Path(90)"+findPath(root, 90));

    }

    static List<Node> findPath(Node root, int data) {
        LinkedList<Node> path = new LinkedList<>();
        while(root != null) {
            path.add(root);
            if(root.data == data)break;
            else if(data >root.data) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        if(root == null) path.clear();
        return path;
    }

    static Node add(Node root, int data ){
        Node newNode = new Node(data);
        if (root == null) return newNode;
        else if (data < root.data) root.left = add(root.left, data);
        else root.right = add(root.right, data);
        return root;
    }
}
