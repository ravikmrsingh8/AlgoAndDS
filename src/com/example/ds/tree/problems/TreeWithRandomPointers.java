package com.example.ds.tree.problems;

/*===========================================
       45                   Random Pointers
     /    \                 45->50; 35->60; 60->20; 20->20; 38->45; 50->null
    35    60
   / \    /
  20  38 50
=============================================*/

import java.util.HashMap;
import java.util.Map;

public class TreeWithRandomPointers {
    public static void main(String[] args) {
        RNode root = new RNode(45);
        root.left = new RNode(35);
        root.left.left = new RNode(20);
        root.left.right = new RNode(38);
        root.right = new RNode(60);
        root.right.left = new RNode(50);

        //Random Links
        root.random = root.right.left;
        root.left.random = root.right;
        root.right.random = root.left.left;
        root.left.left.random = root.left.left;
        root.left.right.random = root;
        root.right.left.random = null;

        System.out.println("Tree");
        Utility.levelOrderLineByLine(root);

        System.out.println("\nCloned Tree");
        RNode root2 = clone(root);
        Utility.levelOrderLineByLine(root2);
    }

    private static RNode clone(RNode root) {
        Map<RNode,RNode> map = new HashMap<>();
        copyNode(root, map);
        storeLinks(root,map);
        return map.get(root);
    }


    private static void copyNode(RNode root,Map<RNode, RNode> map) {
        if(root == null) return;
        RNode rNode = new RNode(root);
        map.put(root,rNode);
        copyNode(root.left,map);
        copyNode(root.right, map);
    }

    private static void storeLinks(RNode root,Map<RNode, RNode> map) {
        if(root == null) return;
        RNode rNode = map.get(root);
        rNode.left = map.get(root.left);
        rNode.right = map.get(root.right);
        rNode.random = map.get(root.random);
        storeLinks(root.left,map);
        storeLinks(root.right, map);
    }
}
