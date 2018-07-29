package com.example.amazon.tree;

public class Tree {
    Node root;
    Tree(Node root){
        this.root = root;
    }

    boolean isBalanced() {
        return balanced(root).balanced;
    }

    Pair balanced(Node root){
        if(root == null) {
            return new Pair(true, 0);
        }

        Pair lt = balanced(root.left);
        Pair rt = balanced(root.right);
        boolean balanced = lt.balanced && rt.balanced && Math.abs(lt.height-rt.height)<=1;
        int height = 1 + Math.max(lt.height, rt.height);
        return new Pair(balanced, height);
    }

    class Pair {
        boolean balanced;
        int height;
        Pair(boolean balanced, int height){
            this.balanced = balanced;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.left.left = new Node(7);
        Tree tree = new Tree(root);
        System.out.println("Tree is Balanced :"+tree.isBalanced());
    }

}
