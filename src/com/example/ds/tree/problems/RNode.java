package com.example.ds.tree.problems;


public class RNode {
    public int data;
    public RNode left;
    public RNode right;
    public RNode random;


    public RNode(int data) {
        this.data = data;
    }

    public RNode(RNode node) {
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
                .append("RAND:")
                .append(random != null ? String.valueOf(random.data) : "")
                .append(",")
                .append("@" + Integer.toHexString(hashCode()))
                .append("]")
                .toString();
    }
}

