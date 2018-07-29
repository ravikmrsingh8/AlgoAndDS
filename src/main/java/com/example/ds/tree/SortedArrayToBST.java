package com.example.ds.tree;

public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        Node root = toTree(arr);

        System.out.println("Tree");
        Utility.levelOrderLineByLine(root);
    }

    private static Node toTree(int[] arr) {
        return toTree(arr, 0, arr.length-1);
    }
    private static Node toTree(int[] arr, int l, int r) {
        if(l > r) return null;
        int mid = l + (r-l)/2;
        Node root = new Node(arr[mid]);
        root.left = toTree(arr, l, mid-1);
        root.right = toTree(arr,mid+1,r);
        return root;
    }
}
