package com.example.ds.tree;
/*=========================================================
              1
            /   \
          2      3
        /  \
      4     5
     /
    7

 =========================================================*/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class AllAncestors {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.left.left = new Node(7);
        root.right = new Node(3);
        root.left.right = new Node(5);
        System.out.println("Tree");
        Utility.levelOrderLineByLine(root);
        System.out.println();
        System.out.println("All Ancestor of "+7);
        printAllAncestors(root,7);
        System.out.println();
        System.out.println("All Ancestor of "+7);
        printAllAncestors1(root, 7);

        System.out.println();
        System.out.println("All Ancestor of "+7);
        allAncestors(root, 7);
    }
    //Solution 1 Using Path Array
    private static void printAllAncestors(Node root,int i) {
        preOrder(root, i,new Node[1000],0);
    }

    private static boolean preOrder(Node root, int i, Node[] path, int level) {
        //System.out.println("processing "+ ((root!= null)?root: "null"));
        if(root == null) return false;
        else if(root.data == i) {
            printPath(path, level);
            return true;
        } else {
            path[level] = root;
            return  preOrder(root.left,i,path,level+1)
                    || preOrder(root.right,i,path,level+1);

        }
    }

    private static void printPath(Node[] path, int N) {
        for(int i=0;i<N; i++) System.out.print(path[i]);
    }



    //Solution 2 Using list
    private static void printAllAncestors1(Node root, int node) {
        LinkedList<Node> nodes = new LinkedList<>();
        hasNode(root,node,nodes);
        nodes.forEach((n)-> System.out.print(n));
    }

    private static boolean hasNode(Node root, int node, LinkedList<Node> nodes) {
        if(root == null) return false;
        else if(root.data == node) {
            return true;
        } else {
            nodes.add(root);
            boolean hasNode = hasNode(root.left,node,nodes) || hasNode(root.right, node, nodes);
            if(hasNode) return true;
            nodes.pollLast();
            return false;
        }
    }

    //Solution 3 using Map
    private static void allAncestors(Node root, int node) {
        Map<Integer, Node> map = new HashMap<>();
        map.put(root.data, null);
        preOrder(root,map);
        Node parent = map.get(node);
        while(parent != null) {
            System.out.print(parent);
            parent = map.get(parent.data);
        }
        System.out.println();
    }
    private static void preOrder(Node root, Map<Integer,Node> map) {
        if(root == null) return;
        if(root.left != null) map.put(root.left.data, root);
        if(root.right != null) map.put(root.right.data, root);
        preOrder(root.left,map);
        preOrder(root.right,map);
    }

}
