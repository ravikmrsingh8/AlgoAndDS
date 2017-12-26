package com.example.ds.tree.problems;
/*===========================================
        45         Paths
     /     \       45->35->20
    35     60      45->35->38->36
   / \     /       45->35->38->40
  20  38  50       45->60->50
     /  \
    36   40
=============================================*/


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class PathFromRootToLeaf {
    public static void main(String[] args) {
        Node root = new Node(45);
        root.left = new Node(35);
        root.left.left = new Node(20);
        root.left.right = new Node(38);
        root.left.right.right = new Node(40);
        root.left.right.left = new Node(36);
        root.right = new Node(60);
        root.right.left = new Node(50);
        System.out.println("Tree");
        Utility.levelOrderLineByLine(root);

        System.out.println("\nAll Paths (Rec)");
        printPathsRec(root);

        System.out.println("\nAll Paths Using List(Rec)");
        printPathsUsingList(root);


        System.out.println("\nAll Paths (UsingMap)");
        printPaths(root);

        System.out.println("\nAll Paths Using Map Iterative");
        printPathsItr(root);
    }

    //Solution 1
    private static void printPathsRec(Node root) {
        // Arrays size should not be defined like this
        // As we don't know how deep the given tree could be
        Node[] nodes = new Node[100];
        printPathsRecUtil(root, nodes, 0);
    }

    private static void printPathsRecUtil(Node root, Node[] nodes, int level) {
        if (root == null) return;
        nodes[level] = root;
        if (root.left == null && root.right == null) {
            printPath(nodes, level);
        }
        printPathsRecUtil(root.left, nodes, level + 1);
        printPathsRecUtil(root.right, nodes, level + 1);
    }

    private static void printPath(Node[] path, int pathSize) {
        for (int i = 0; i <= pathSize; i++) {
            System.out.print(path[i] + "\t");
        }
        System.out.println();
    }


    // Solution 2 use list
    private static  void printPathsUsingList(Node root) {
        if(root == null) return;
        LinkedList<Node> path = new LinkedList<>();
        printPaths(root, path);
    }

    private static void printPaths(Node root, LinkedList<Node> path) {
        if(root == null) return;
        path.add(root);
        if(root.left == null && root.right == null) System.out.println(path);
        printPaths(root.left, path);
        printPaths(root.right,path);
        path.pollLast();
    }
    // Solution 3
    // Alternate Solution using Map
    // For each DNode store their parent,
    // Then simply when you reach end, print path using map;
    private static void printPaths(Node root) {
        Map<Node, Node> map = new HashMap<Node, Node>();
        map.put(root, null);
        printPathsUtil(root, map);
    }

    private static void printPathsUtil(Node root, Map<Node, Node> map) {
        if (root == null) return;
        if (root.left == null && root.right == null) printPath(root, map);
        if (root.left != null) map.put(root.left, root);
        if (root.right != null) map.put(root.right, root);
        printPathsUtil(root.left, map);
        printPathsUtil(root.right, map);
    }

    private static void printPath(Node node, Map<Node, Node> map) {
        Stack<Node> nodes = new Stack<Node>();
        while (node != null) {
            nodes.push(node);
            node = map.get(node);
        }
        while(!nodes.isEmpty()){
            System.out.print(nodes.pop()+"\t");
        }
        System.out.println();
    }


    //Solution 4
    //Use pre-order iterative, map nodes with their parent
    //when you reach leaf print path using map
    private static void printPathsItr(Node root) {
        if(root == null) return;
        Stack<Node> stack = new Stack<>();
        Map<Node, Node> map = new HashMap<>();
        map.put(root, null);
        stack.push(root);
        // 1st traversal will  map node to their parent
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            if(node.right != null) {
                map.put(node.right,node);
                stack.push(node.right);
            }
            if(node.left != null) {
                map.put(node.left, node);
                stack.push(node.left);
            }
        }

        // 2nd Traversal will be used to display path
        stack.push(root);
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            if(node.left == null && node.right == null) {
                printPath(node, map);
            }
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
    }
}
