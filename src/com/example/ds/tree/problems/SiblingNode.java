package com.example.ds.tree.problems;

/*==========================================
     6
   /   \
  3     5               (3,8) False
 / \   / \              (3,5) True
7   8 1   3             (7,1) False
===========================================*/
public class SiblingNode {
    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(8);

        root.right = new Node(5);
        root.right.left = new Node(1);
        root.right.right = new Node(3);

        System.out.println("Tree");
        Utility.levelOrderLineByLine(root);
        System.out.println();
        System.out.println("Is Sibling(3,8): " + isSibling(root, 3, 8));
        System.out.println("Is Sibling(3,5): " + isSibling(root, 3, 5));
        System.out.println("Is Sibling(1,7): " + isSibling(root, 7, 1));
    }

    private static boolean isSibling(Node root, int p, int q) {
        if (root == null) {
            return false;
        }
        if (root.left != null && root.right != null) {
            if (root.left.data == p && root.right.data == q || root.left.data == q && root.right.data == p) {
                return true;
            }
        }
        return isSibling(root.left, p, q) || isSibling(root.right, p, q);
    }

}
