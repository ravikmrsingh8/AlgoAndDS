package com.example.ds.tree;

/*===================================================

      45
    /    \
   35     60
   / \    /
 20  38 50
 ====================================================*/
public class BinaryTreeToDLL {
    public static void main(String[] args) {
        Node root = new Node(45);
        root.left = new Node(35);
        root.left.left = new Node(20);
        root.left.right = new Node(38);
        root.right = new Node(60);
        root.right.left = new Node(50);

        System.out.println("Tree");
        Utility.levelOrderLineByLine(root);
        Node head = toDLL(root);
        System.out.println("DLL");
        printList(head);
    }

    public static Node concat(Node left, Node right) {
        if (left == null) return right;
        else if (right == null) return left;
        else {
            Node leftLast = left.left;
            Node rightLast = right.left;

            leftLast.right = right;
            right.left = leftLast;

            rightLast.right = left;
            left.left = rightLast;
        }
        return left;
    }

    public static Node toDLL(Node root) {
        if (root == null) return null;
        else {
            Node leftList = toDLL(root.left);
            Node rightList = toDLL(root.right);
            root.left = root;
            root.right = root;
            return concat(concat(leftList, root), rightList);
        }
    }

    static void printList(Node head) {
        Node cur = head;
        do {
            System.out.print(cur + "\t");
            cur = cur.right;
        } while (cur != head);
    }
}
