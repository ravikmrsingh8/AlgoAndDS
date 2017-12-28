package com.example.ds.tree.problems;
/*=========================================================
              1
            /   \
          2      3
        /  \
      4     5
     /     / \
    7     9   8

 =========================================================*/

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindDistanceBetweenNodes {
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


        System.out.println("Dist(2, 8)="+ dist(root, 2,8));
        System.out.println("Dist(4, 9)="+ dist(root, 4,9));
        System.out.println("Dist(1, 8)="+ dist(root, 1,8));
        System.out.println("Dist(1, 1)="+ dist(root, 1,1));
        System.out.println("Dist(1, 3)="+ dist(root, 1,3));
        System.out.println("Dist(1, 0)="+ dist(root, 1,0));

    }

    static List<Node> findPath(Node root, int data) {
        LinkedList<Node> path = new LinkedList<>();
        findPath(root, path, data);
        //System.out.println(path);
        return path;
    }

    static boolean findPath(Node root, LinkedList<Node> path, int data) {
        if(root == null) return false;

        path.add(root);
        if(root.data == data) return true;

        boolean found = findPath(root.left, path, data)|| findPath(root.right, path, data);
        if(found) return true;
        else {
            path.pollLast();
            return false;
        }
    }
    static int dist(Node root, int a, int b) {
        List<Node> pathA = findPath(root, a);
        List<Node> pathB = findPath(root, b);

        //if any of node not found return INF value
        if(pathA.isEmpty() || pathB.isEmpty()) return Integer.MAX_VALUE;
        int lcaDist = lcaDist(pathA, pathB);
        return pathA.size() + pathB.size() - 2 * lcaDist;
    }

    static  int lcaDist(List<Node> pathA, List<Node> pathB){
        Iterator<Node> iA = pathA.iterator();
        Iterator<Node> iB = pathB.iterator();
        int lcaDist = 0;
        while(iA.hasNext() && iB.hasNext()) {
            if(iA.next() == iB.next()) {
                lcaDist++;
            } else {
                return lcaDist;
            }
        }
        return lcaDist;
    }
}