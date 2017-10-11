package com.example.ds.tree.problems;

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
        System.out.println("Tree is SumTree(O(N^2)):"+isSumTree1(root));


        System.out.println("Tree");
        Utility.levelOrderLineByLine(root);
        System.out.println("Tree is SumTree O(N):"+isSumTree2(root));
    }



    //Solution1 Not efficient O(N^2)
    private static boolean isSumTree1(Node root) {
        if(root == null) return true;
        else if(root.left == null && root.right == null) {
            return true;
        } else {
            return root.data == sum(root.left) + sum(root.right)
                    && isSumTree1(root.left)
                    && isSumTree1(root.right);
        }
    }

    private static int sum(Node root) {
        if(root == null) return 0;
        return root.data + sum(root.left) + sum(root.right);
    }

    //Solution 2 efficient
    private static boolean isSumTree2(Node root) {
        if(root == null) {
            return true;
        } if(isLeaf(root)){
            return true;
        } else {
            int leftSum = 0;
            if(root.left == null) leftSum =0;
            else if(isLeaf(root.left)) leftSum = root.left.data;
            else leftSum = 2*root.left.data;

            int rightSum = 0;
            if(root.right == null ) rightSum = 0;
            else if(isLeaf(root.right)) rightSum = root.right.data;
            else rightSum = 2*root.right.data;

            return root.data == leftSum + rightSum
                    && isSumTree2(root.left)
                    && isSumTree2(root.right);
        }

    }
    private static boolean isLeaf(Node node){
        return node.left == null && node.right == null;
    }
}
