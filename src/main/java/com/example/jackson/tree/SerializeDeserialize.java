package com.example.jackson.tree;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class SerializeDeserialize {
    public static void main(String[] args) throws IOException {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);

        Utility.levelOrderLineByLine(root);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);

        System.out.println("Serialized Tree\n" + json);

        Node revivedRoot = mapper.readValue(json, Node.class);
        System.out.println("De serialized Tree");
        Utility.levelOrderLineByLine(revivedRoot);

    }
}
