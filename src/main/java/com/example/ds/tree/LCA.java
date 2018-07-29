package com.example.ds.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*=========================================================
              1
            /   \
          2      3
        /  \
      4     5
     /     / \
    7     9   8

 =========================================================*/
public class LCA {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.left.left = new Node(7);

        root.right = new Node(3);
        root.left.right = new Node(5);
        root.left.right.left = new Node(9);
        root.left.right.right = new Node(8);

        System.out.println("Tree");
        Utility.levelOrderLineByLine(root);

        System.out.println();
        System.out.println("lca(2,5)" + lca(root, 2, 5));
        System.out.println("lca(7,9)" + lca(root, 7, 9));
        System.out.println("lca(9,7)" + lca(root, 9, 7));
        System.out.println("lca(7,3)" + lca(root, 7, 3));
        System.out.println("lca(1,10)" + lca(root, 1, 10));
        System.out.println("lca(0,8)" + lca(root, 0, 8));
    }


    static Node lca(Node root, int a, int b) {
        List<Node> pathA = findPath(root, a);
        List<Node> pathB = findPath(root, b);
        if (pathA.isEmpty() || pathB.isEmpty()) return null;

        Node lca = null;
        Iterator<Node> iA = pathA.iterator();
        Iterator<Node> iB = pathB.iterator();
        while (iA.hasNext() && iB.hasNext()) {
            Node nodeA = iA.next();
            Node nodeB = iB.next();
            if (nodeA != nodeB) return lca;
            else {
                lca = nodeA;
            }
        }
        return lca;
    }

    static List<Node> findPath(Node root, int a) {
        LinkedList<Node> path = new LinkedList<Node>();
        findPath(root, path, a);
        return path;
    }

    static boolean findPath(Node root, LinkedList<Node> path, int data) {
        if (root == null) return false;
        path.add(root);
        if (root.data == data) return true;
        boolean found = findPath(root.left, path, data) || findPath(root.right, path, data);
        if (found) return true;
        else {
            path.pollLast();
            return false;
        }
    }
}
