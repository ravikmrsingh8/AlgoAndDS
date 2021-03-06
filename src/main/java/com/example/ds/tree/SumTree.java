package com.example.ds.tree;

public class SumTree {
    public static void main(String[] args) {
        Node root = new Node(26);
        root.left = new Node(10);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.right = new Node(3);

        System.out.println("Tree");
        Utility.levelOrderLineByLine(root);
        System.out.println("Tree is SumTree(O(N^2)):" + isSumTree1(root));


        System.out.println("Tree");
        Utility.levelOrderLineByLine(root);
        System.out.println("Tree is SumTree O(N):" + isSumTree2(root));
    }


    //Solution1 Not efficient O(N^2)
    private static boolean isSumTree1(Node root) {
        if (root == null) return true;
        else if (isLeaf(root)) {
            return true;
        } else {
            return root.data == sum(root.left) + sum(root.right)
                    && isSumTree1(root.left)
                    && isSumTree1(root.right);
        }
    }

    private static int sum(Node root) {
        if (root == null) return 0;
        return root.data + sum(root.left) + sum(root.right);
    }

    //Solution 2 efficient
    private static boolean isSumTree2(Node root) {
        if (root == null) {
            return true;
        }
        if (isLeaf(root)) {
            return true;
        } else {
            int leftSum = 0;
            int rightSum = 0;
            if (root.left != null){
                leftSum = isLeaf(root.left)?root.left.data : 2 * root.left.data;
            }
            if(root.right != null) {
                rightSum = isLeaf(root.right)? root.right.data : 2 * root.right.data;
            }
            return root.data == leftSum + rightSum
                    && isSumTree2(root.left)
                    && isSumTree2(root.right);
        }

    }

    private static boolean isLeaf(Node node) {
        if (node == null) return false;
        return node.left == null && node.right == null;
    }
}
