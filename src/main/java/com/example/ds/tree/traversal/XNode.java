package com.example.ds.tree.traversal;


import com.example.ds.tree.node.Node;

public class XNode {
    private Node node;
    private int x;

    public XNode(Node node, int x) {
        setNode(node);
        setX(x);
    }

    public XNode(Node node) {
        this(node,0);
    }


    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
