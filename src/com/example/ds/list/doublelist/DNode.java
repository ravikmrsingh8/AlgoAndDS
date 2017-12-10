package com.example.ds.list.doublelist;


public class DNode {
    public int data;
    public DNode prev;
    public DNode next;

    public DNode(int data) {
        this.data = data;
        prev = null;
        next = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append("P:" + nodeData(prev)).append(",");
        sb.append("D:" + data).append(",");
        sb.append("N:"+  nodeData(next)).append(",");
        sb.append("@"+Integer.toHexString(hashCode()));
        sb.append("]");
        return sb.toString();
    }

    private String nodeData(DNode node) {
        if (node == null) return "null";
        return String.valueOf(node.data);
    }
}
