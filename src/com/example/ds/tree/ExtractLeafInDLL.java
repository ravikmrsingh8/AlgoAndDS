package com.example.ds.tree;

/*===============================================
              1
            /   \
          2      3
        /  \
      4     5
     /
    7
================================================= */
public class ExtractLeafInDLL {
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

        //Get all Leafs from tree into this list from left to right
        Node head = extractLeafs(root);
        System.out.println("List");
        printList(head);

        //Print Tree to make sure that leafs are gone
        System.out.println("Tree");
        Utility.levelOrderLineByLine(root);
    }

    private static Node extractLeafs(Node root) {
        //TODO
        return null;
    }

    private static boolean isLeaf(Node node) {
        if(node == null) return false;
        return node.left == null && node.right == null;
    }
    private static void printList(Node head) {
        while(head != null) {
            System.out.print(head);
            head = head.right;
        }
        System.out.println();
    }

}
