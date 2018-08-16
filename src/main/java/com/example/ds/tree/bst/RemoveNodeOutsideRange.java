package com.example.ds.tree.bst;

import com.example.ds.tree.Node;
import com.example.ds.tree.Utility;

/**
 * Remove BST keys outside the given range
 * Given a Binary Search Tree (BST) and a range [min, max],
 * remove all keys which are outside the given range.
 * The modified tree should also be BST. For example, consider the following BST and range [-10, 13].
 * BinaryTree1
 *            6
 *         /    \
 *      -13      14
 *        \     /   \
 *        -8   13    15
 *            /
 *           7
 * The given tree should be changed to following. Note that all keys outside the range [-10, 13] are removed and modified tree is BST.
 * BinaryTreeModified2
 *
 *          6
 *        /   \
 *      -8   13
 *           /
 *          7
 */
public class RemoveNodeOutsideRange {
    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(-13);
        root.left.right = new Node(-8);
        root.right = new Node(14);
        root.right.left = new Node(13);
        root.right.left.left = new Node(7);
        root.right.right = new Node(15);
        Utility.levelOrderLineByLine(root);
        Node root1 = trim(root, -10, 13);

        System.out.println("\nModified Tree");
        Utility.levelOrderLineByLine(root1);
    }

    static Node trim(Node root, int L, int R) {
        if (root == null) return null;
        root.left = trim(root.left, L, R);
        root.right = trim(root.right, L, R);
        if (root.data < L) root = root.right;
        if (root.data > R) root = root.left;
        return root;
    }

}
