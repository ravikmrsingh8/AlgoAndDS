package com.example.ds.tree.problems;

import java.util.HashMap;
import java.util.Map;

/*=================================================
       45                                  45
     /    \                              /    \
    35    60                           60      35
   / \    /                             \     /  \
  20  38 50                             50   38   20

 ==================================================*/
public class MirrorTree {
    public static void main(String[] args) {
        //Tree 1
        Node root1 = new Node(45);
        root1.left = new Node(35);
        root1.left.left = new Node(20);
        root1.left.right = new Node(38);
        root1.right = new Node(60);
        root1.right.left = new Node(50);

        //Tree 2
        Node root2 = new Node(45);
        root2.right = new Node(35);
        root2.right.right = new Node(20);
        root2.right.left = new Node(38);
        root2.left = new Node(60);
        root2.left.right = new Node(50);

        System.out.println("Tree1");
        Utility.levelOrderLineByLine(root1);

        System.out.println("\nTree2");
        Utility.levelOrderLineByLine(root2);

        System.out.println("Tree2 Mirror Of Tree1: " + isMirror(root1, root2));

        Node mirrorRoot = mirror(root1);
        System.out.println("\nCloned Mirror of Tree1");
        Utility.levelOrderLineByLine(mirrorRoot);

        mirrorRoot = createMirrorTreeRec(root1);
        System.out.println("\nCloned Mirror of Tree1(Rec)");
        Utility.levelOrderLineByLine(mirrorRoot);


        System.out.println("\nTree1");
        Utility.levelOrderLineByLine(root1);
        convertToMirror(root1);
        System.out.println("Tree1 Converted to its Mirror:");
        Utility.levelOrderLineByLine(root1);


    }

    private static boolean isMirror(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        else if (root1 == null) return false;
        else if (root2 == null) return false;
        else return root1.data == root2.data && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }

    private static Node mirror(Node root) {
        Map<Node, Node> map = new HashMap<>();
        preOrder(root, map);
        createLinks(root, map);
        return map.get(root);
    }

    private static void preOrder(Node root, Map<Node, Node> map) {
        if (root == null) return;
        map.put(root, new Node(root));
        preOrder(root.left, map);
        preOrder(root.right, map);
    }

    private static void createLinks(Node root, Map<Node, Node> map) {
        if (root == null) return;
        Node root1 = map.get(root);
        root1.left = map.get(root.right);
        root1.right = map.get(root.left);
        createLinks(root.left, map);
        createLinks(root.right, map);
    }

    private static void convertToMirror(Node root) {
        if (root == null) return;
        Node t = root.left;
        root.left = root.right;
        root.right = t;
        convertToMirror(root.left);
        convertToMirror(root.right);
    }

    private static Node createMirrorTreeRec(Node root){
        if(root == null) return null;
        Node leftNode = createMirrorTreeRec(root.left);
        Node rightNode = createMirrorTreeRec(root.right);
        Node rootNode = new Node(root);
        rootNode.left = rightNode;
        rootNode.right = leftNode;
        return rootNode;
    }

}
