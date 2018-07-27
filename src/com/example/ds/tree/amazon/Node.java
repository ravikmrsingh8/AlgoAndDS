package com.example.ds.tree.amazon;

public class Node {
    public int data;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }
    public Node(Node node) {
        this.data = node.data;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("[L:")
                .append(left != null ? String.valueOf(left.data) : "")
                .append(",")
                .append(data)
                .append(",")
                .append("R:")
                .append(right != null ? String.valueOf(right.data) : "")
                .append(",")
                .append("@"+Integer.toHexString(hashCode()))
                .append("]")
                .toString();
    }
}
