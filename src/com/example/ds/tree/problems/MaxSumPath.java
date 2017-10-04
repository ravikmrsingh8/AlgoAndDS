package com.example.ds.tree.problems;

import java.util.List;

/*===========================================
       45
     /    \
    35    60    Max Sum Path 40->60->50
   / \    /
  20  38 50

=============================================*/
public class MaxSumPath {
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
        System.out.println("nMax Sum Path :"+ maxSumPath);
    }

    private static List<Node> maxSumPath(Node root) {
        //TODO
        return null;
    }

    private static int maxSum(Node root) {
        WrapInt max = new WrapInt(0);
        maxSum(root,0, max);
        return max.value;
    }

    private static void maxSum(Node root, int sum, WrapInt max) {
        if (root == null) return;
        sum += root.data;
        if(sum > max.value) max.value = sum;
        maxSum(root.left, sum, max);
        maxSum(root.right, sum, max);
    }

    static class WrapInt{
        int value;
        WrapInt(int value) {
            this.value = value;
        }
    }
}
