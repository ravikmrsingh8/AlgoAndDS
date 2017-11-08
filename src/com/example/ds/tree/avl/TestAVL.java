package com.example.ds.tree.avl;

public class TestAVL {
    public static void main(String[] args) {
        Node root = null;
        AVL avl = new AVL();
        root = avl.insert(root, 10);
        root = avl.insert(root, 20);

        root = avl.insert(root, 30);
        System.out.println("AVL Tree");
        Utility.levelOrderLineByLine(root);
        root = avl.insert(root, 40);
        root = avl.insert(root, 50);
        System.out.println("AVL Tree");
        Utility.levelOrderLineByLine(root);
        root = avl.insert(root, 25);

        System.out.println("AVL Tree");
        Utility.levelOrderLineByLine(root);

    }
}
