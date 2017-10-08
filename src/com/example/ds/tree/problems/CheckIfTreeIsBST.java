package com.example.ds.tree.problems;

/*===========================================
       45                               3
     /    \                            / \
    35    60   Bst - True             2   5     Bst - False
   / \    /                          / \
  20  38 50                         1   4

=============================================*/

import java.util.LinkedList;
import java.util.List;

public class CheckIfTreeIsBST {
    public static void main(String[] args) {
        //Tree 1
        Node root = new Node(45);
        root.left = new Node(35);
        root.left.left = new Node(20);
        root.left.right = new Node(38);
        root.right = new Node(60);
        root.right.left = new Node(50);
        System.out.println("Tree1");
        Utility.levelOrderLineByLine(root);

        //Tree 2
        Node root2 = new Node(3);
        root2.left = new Node(2);
        root2.left.left = new Node(1);
        root2.left.right = new Node(4);
        root2.right = new Node(5);
        System.out.println("Tree2");
        Utility.levelOrderLineByLine(root2);


        // Do inorder and check sorted Order
        System.out.println("Tree1 is BST :" + isBST(root));
        System.out.println("Tree2 is BST :" + isBST(root2));


        //Recursive Solution
        System.out.println("Tree1 is BST(Rec) :" + isBSTRec(root));
        System.out.println("Tree2 is BST(Rec) :" + isBSTRec(root2));
    }

    //Solution 1,  Do Inorder Traversal and Check if they are in Sorted Order;
    private static boolean isBST(Node root) {
        List<Node> list = new LinkedList<>();
        if (root == null) return true;
        inOrder(root, list);
        Node prevNode = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Node curNode = list.get(i);
            if (prevNode.data > curNode.data) return false;
            prevNode = curNode;
        }
        return true;
    }
    private static void inOrder(Node root, List<Node> list) {
        if(root == null) return;
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }

    //Solution 2, Recursive
    private static boolean isBSTRec(Node root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private static boolean isBSTUtil(Node root, int min, int max) {
        if (root == null) return true;
        return min < root.data
                && max > root.data
                && isBSTUtil(root.left, min, root.data)
                && isBSTUtil(root.right, root.data, max);

    }
}
