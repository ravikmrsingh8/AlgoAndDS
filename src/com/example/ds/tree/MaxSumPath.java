package com.example.ds.tree;

import java.util.LinkedList;
import java.util.List;

/*===========================================
       45
     /    \
    35    60    Max Sum Path 40->60->50
   / \    /
  20  38 50

=============================================*/
public class MaxSumPath {
    private static int maxSum = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Node root = new Node(45);
        root.left = new Node(35);
        root.left.left = new Node(20);
        root.left.right = new Node(38);
        root.right = new Node(60);
        root.right.left = new Node(50);
        System.out.println("Tree");
        Utility.levelOrderLineByLine(root);
        int sum = maxSum(root);
        System.out.println("\nMaximum sum in Path :"+sum);

        List<Node> maxSumPath = maxSumPath(root);
        System.out.println("Max Sum Path :"+ maxSumPath);
    }


    //Solution1
    private static int maxSum(Node root) {
        maxSum(root,0);
        return maxSum;
    }

    private static void maxSum(Node root, int sum) {
        if (root == null) return;
        sum += root.data;
        if(sum > maxSum) maxSum = sum;
        maxSum(root.left, sum);
        maxSum(root.right, sum);
    }


    //Solution1
    private static LinkedList<Node> path = new LinkedList<>();
    private static LinkedList<Node> maxSumPath = new LinkedList<>();
    private static List<Node> maxSumPath(Node root) {
        maxSum = Integer.MIN_VALUE;
        maxSumPath(root,Integer.MIN_VALUE);
        return maxSumPath;
    }
    private static void maxSumPath(Node root, int sum) {
        if(root == null) return;
        sum += root.data;
        path.add(root);

        if(root.left == null && root.right == null && sum > maxSum) {
            updatePath();
            maxSum = sum;
        }
        maxSumPath(root.left, sum);
        maxSumPath(root.right, sum);
        path.pollLast();
    }
    private static void updatePath(){
        maxSumPath.clear();
        path.forEach((node)-> maxSumPath.add(node));
    }
}
