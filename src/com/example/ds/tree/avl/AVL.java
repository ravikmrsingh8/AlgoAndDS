package com.example.ds.tree.avl;

public class AVL {
    public Node insert(Node root, int data) {
        if (root == null) return new Node(data);
        else if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        int bFactor = getBalanceFactor(root);

        if (bFactor > 1) {
            // Node added in Left Subtree
            if (data < root.left.data) {
                // LL Case, do right rotate
                return rightRotate(root);
            } else if (data > root.left.data) {
                //LR Case, do left rotate around left child of root and then right rotate around root
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
        } else if (bFactor < -1) {
            // Node added in right subtree
            if (data > root.right.data) {
                //RR Case, Do left rotate around root
                return leftRotate(root);
            } else if (data < root.right.data) {
                //RL Case, do right rotate around right child of root and then left rotate around root
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }
        }
        return root;
    }

    public Node leftRotate(Node root) {
        Node rightChild = root.right;
        //Left subtree of right child
        Node lsrc = rightChild.left;

        rightChild.left = root;
        root.right = lsrc;

        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        rightChild.height = 1 + Math.max(getHeight(rightChild.left), getHeight(rightChild.right));

        return rightChild;
    }

    public Node rightRotate(Node root) {
        Node leftChild = root.left;
        // Right sub tree of left child
        Node rslc = leftChild.right;

        leftChild.right = root;
        root.left = rslc;

        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        leftChild.height = 1 + Math.max(getHeight(leftChild.left), getHeight(leftChild.right));

        return leftChild;
    }

    public int getHeight(Node root) {
        return root != null ? root.height : 0;
    }

    public int getBalanceFactor(Node root) {
        return root == null ? 0 : getHeight(root.left) - getHeight(root.right);
    }
}
