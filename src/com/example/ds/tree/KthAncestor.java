package com.example.ds.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*=========================================================
              1
            /   \
          2      3
        /  \
      4     5
     /
    7

 =========================================================*/
public class KthAncestor {
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
        int ancestor = getKthAncestor(root,7,3);
        System.out.println("3rd Ancestor of 7: " + ancestor);

        ancestor = getKthAncestorUsingMap(root,5,1);
        System.out.println("1st Ancestor of 5: " + ancestor);
    }
    //Solution 1
    private static int getKthAncestor(Node root, int node, int k) {
        LinkedList<Integer> path = new LinkedList<>();
        getPath(root,node,path);
        System.out.println("All Ancestors of "+ node+": "+path);
        return path.size() >= k ? path.get(path.size()-k):-1;
    }
    private static boolean getPath(Node root, int node, LinkedList<Integer> path){
        if(root == null) return false;
        else if(root.data == node){
            return true;
        } else {
            path.add(root.data);
            boolean hasData = getPath(root.left,node,path)|| getPath(root.right,node,path);
            if(hasData) return true;
            path.pollLast();
            return false;
        }
    }


    //Solution 2
    static int getKthAncestorUsingMap(Node root, int node, int k){
        Map<Integer, Node> map = new HashMap<Integer, Node>();
        map.put(root.data, new Node(-1));
        inOrder(root,map);
        int idx = 0;
        do {
            idx +=1;
            node = map.get(node).data;
        } while(node != -1 && idx < k);
        return node;
    }
    static void inOrder(Node root, Map<Integer,Node> map){
        if(root == null) return;
        inOrder(root.left,map);
        if(root.left != null) map.put(root.left.data, root);
        if(root.right != null) map.put(root.right.data, root);
        inOrder(root.right, map);
    }
}
