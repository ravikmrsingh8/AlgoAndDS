package com.example.ds.tree.problems;
/*================================================
*         10
*       /   \
*      8     2
*     / \     \
*    3  5      2
*==================================================*/

public class ChildrenSumProperty {
    public static void main(String[] args) {
        //Tree1
        Node root1 = new Node(10);
        root1.left = new Node(8);
        root1.right = new Node(2);
        root1.left.left = new Node(3);
        root1.left.right = new Node(5);
        root1.right.right = new Node(2);

        System.out.println("Tree1");
        Utility.levelOrderLineByLine(root1);
        System.out.println("Children Sum Property for Tree1: " + childrenSumProperty(root1));
    }

    private static boolean childrenSumProperty(Node root) {
        if (root == null) return true;
        else if (root.left == null && root.right == null) return true;
        else if (root.left == null) return root.data == root.right.data;
        else if (root.right == null) return root.data == root.left.data;
        else return root.data == root.left.data + root.right.data
                    && childrenSumProperty(root.left)
                    && childrenSumProperty(root.right);
    }
}
