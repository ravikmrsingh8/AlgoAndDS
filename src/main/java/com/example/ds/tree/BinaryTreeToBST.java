package com.example.ds.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.ds.tree.Utility.levelOrderLineByLine;

/*===============================================
           10
         /  \
        2    7
       / \
      8   4

=================================================*/
public class BinaryTreeToBST {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.left.left = new Node(8);
        root.left.right = new Node(4);
        root.right = new Node(7);
        System.out.println("Tree");
        Utility.levelOrderLineByLine(root);
        toBST(root);

        System.out.println("Tree After Conversion");
        Utility.levelOrderLineByLine(root);
    }
    //This method only copies data, DNode refs will remain same,
    // If we can only change the links then this would be a tough one
    private static void toBST(Node root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        Collections.sort(list);
        toBST(root,list);
    }

    private static void toBST(Node root, List<Integer> list) {
        if(root == null) return;
        toBST(root.left,list);
        root.data = list.remove(0);
        toBST(root.right,list);
    }

    private static void inOrder(Node root, List<Integer> list) {
        if(root == null) return;
        inOrder(root.left,list);
        list.add(root.data);
        inOrder(root.right,list);
    }
}
