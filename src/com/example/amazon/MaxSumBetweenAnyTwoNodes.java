package com.example.amazon;

public class MaxSumBetweenAnyTwoNodes {
    public static void main(String[] args) {
        Node root = new Node(-15);
        root.left = new Node(5);
        root.right = new Node(6);
        root.left.left = new Node(-8);
        root.left.right = new Node(1);
        root.left.left.left = new Node(2);
        root.left.left.right = new Node(6);
        root.right.left = new Node(3);
        root.right.right = new Node(9);
        root.right.right.right= new Node(0);
        root.right.right.right.left= new Node(4);
        root.right.right.right.right= new Node(-1);
        root.right.right.right.right.left= new Node(10);

        System.out.println(findMaxSum(root));

    }

    static int findMaxSum(Node root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.data;

        int lsum  = findMaxSum(root.left);
        int rsum = findMaxSum(root.right);
        int maxSum = Math.max(lsum, rsum);
        return Math.max(maxSum(root.left)+ root.data +maxSum(root.right), maxSum);
    }


    static int maxSum = 0;
    static int maxSum(Node root) {
        maxSum = 0;
        maxSum(root, 0);
        return maxSum;
    }

    static void maxSum(Node root, int sum) {
        if(root==null) return;
        sum += root.data;
        if(sum>maxSum)maxSum=sum;
        maxSum(root.left, sum);
        maxSum(root.right, sum);
    }
}
