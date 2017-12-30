package com.example.ds.tree;
/*=====================================================
           1
         /  \
        2    3
       / \    \
      4   5   6
     /
    7
=======================================================*/
import java.util.LinkedList;
import java.util.Queue;

public class TreeSerialization {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.left.left = new Node(7);
        System.out.println("Tree1");
        Utility.levelOrderLineByLine(root);

        System.out.println("Serialized Tree");
        String nodes = serialize(root);
        System.out.println(nodes);

        System.out.println("De serialized Tree");
        Node root1 = deserialize(nodes);
        Utility.levelOrderLineByLine(root1);
    }

    private static String serialize(Node root) {
        if(root== null) return "null";
        StringBuilder sb = new StringBuilder();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        sb.append(root.data);
        sb.append(",");
        while(!q.isEmpty()) {
            Node node = q.poll();
            if(node.left != null) {
                sb.append(node.left.data);
                q.offer(node.left);
            } else {
                sb.append("null");
            }
            sb.append(",");
            if(node.right != null) {
                sb.append(node.right.data);
                q.offer(node.right);
            } else {
                sb.append("null");
            }
            sb.append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    static Node deserialize(String nodeStr) {
        String[] nodes = nodeStr.split(",");
        if(nodes.length == 0) return null;
        if("null".equals(nodes[0])) return null;
        Queue<Node> queue = new LinkedList<>();
        int i = 0;
        Node root = new Node(nodes[i]);
        queue.offer(root);
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            String leftChild = nodes[++i];
            if(!"null".equals(leftChild))  {
                node.left = new Node(leftChild);
                queue.offer(node.left);
            }
            String rightChild =  nodes[++i];
            if(!"null".equals(rightChild)) {
                node.right = new Node(rightChild);
                queue.offer(node.right);
            }
        }
        return root;
    }
}
