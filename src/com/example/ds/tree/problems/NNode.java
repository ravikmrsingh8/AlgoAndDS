package com.example.ds.tree.problems;

public class NNode {
    public int data;
    public NNode left;
    public NNode right;
    public NNode next;

    public NNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(hashCode() + "[L:")
                .append(left != null ? String.valueOf(left.data) : "")
                .append(",")
                .append(data)
                .append(",")
                .append("R:")
                .append(right != null ? String.valueOf(right.data) : "")
                .append(",")
                .append("N:")
                .append(next != null ? String.valueOf(next.data) : "")
                .append(",")
                .append("@" + Integer.toHexString(hashCode()))
                .append("]")
                .toString();
    }
}
