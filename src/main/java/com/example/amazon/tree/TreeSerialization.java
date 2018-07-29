package com.example.amazon.tree;

import java.util.Arrays;
import java.util.Iterator;

public class TreeSerialization {

    public static void main(String[] args) {
        Node root             = new Node(20);
        root.left             = new Node(8);
        root.right            = new Node(22);
        root.left.left        = new Node(4);
        root.left.right       = new Node(12);
        root.left.right.left  = new Node(10);
        root.left.right.right = new Node(14);
        System.out.println("PreOrder");
        preOrder(root);

        System.out.println("\nSerialized Tree");
        String tree  = serialize(root);
        System.out.println(tree);

        System.out.println("De serialized tree");
        Node revivedRoot = deserialize(tree);
        preOrder(revivedRoot);
    }


    static String serialize(Node root){
        if(root == null) return "-1 ";
        return String.valueOf(root.data+ " ")
                + serialize(root.left)
                + serialize(root.right);
    }

    static Node deserialize(String stream){
        Iterator<String> itr =Arrays.asList(stream.split("\\s+")).iterator();
        return deserialize(itr);
    }

    static Node deserialize(Iterator<String> itr) {
        String data = itr.next();
        if("-1".equals(data)) return null;
        Node root = new Node(data);
        root.left = deserialize(itr);
        root.right = deserialize(itr);
        return root;
    }


    static void preOrder(Node root) {
        if(root == null) return;
        System.out.print(root.data+",");
        preOrder(root.left);
        preOrder(root.right);
    }
}
