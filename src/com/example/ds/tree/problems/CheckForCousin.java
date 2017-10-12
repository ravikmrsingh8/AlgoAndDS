package com.example.ds.tree.problems;
/*==========================================
     6
   /   \
  3     5               (3,8) False
 / \   / \              (3,5) False
7   8 1   3             (7,1) True
===========================================*/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CheckForCousin {
    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(8);

        root.right = new Node(5);
        root.right.left = new Node(1);
        root.right.right = new Node(3);

        System.out.println("Tree");
        Utility.levelOrderLineByLine(root);
        System.out.println("Is Cousin(3,8): " + isCousin(root, 3, 8));
        System.out.println("Is Cousin(3,5): " + isCousin(root, 3, 5));
        System.out.println("Is Cousin(1,7): " + isCousin(root, 7, 1));
    }

    private static boolean isCousin(Node root, int p, int q) {
        if (root == null) return false;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == null) {
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            } else if (node.data == p || node.data == q){
                    Set<Integer> nodes = new HashSet<>();
                    nodes.add(node.data);
                    Node curr = null;
                    while((curr = queue.poll()) != null) {
                        nodes.add(curr.data);
                    }
                    return nodes.contains(p) && nodes.contains(q);
            } else {
                    if(node.left != null && node.right != null) {
                        int ld = node.left.data;
                        int rd = node.right.data;
                        boolean isSibling = (ld == p && rd == q)  || (ld== q && rd == p);
                        if(isSibling) return false;
                    }
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
            }
        }
        return false;
    }
}
