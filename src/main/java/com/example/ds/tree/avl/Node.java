package com.example.ds.tree.avl;

public class Node {
    public int data;
    public Node left;
    public Node right;
    public int height;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("[L:").append(left != null ? String.valueOf(left.data) : "").append(",")
                .append(data).append(",")
                .append("R:").append(right != null ? String.valueOf(right.data) : "").append(",")
                .append("H:").append(height).append(",")
                .append("@" + Integer.toHexString(hashCode()))
                .append("]").toString();
    }
}
