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
    private  Node head;

    private  Node extractLeafs(Node root) {
        if(root == null) return null;
        if(isLeaf(root)){
            root.right = head;
            if(head != null)head.left = root;
            head = root;
            return null;
        }


        root.right = extractLeafs(root.right);
        root.left = extractLeafs(root.left);
        return root;
    }


    private boolean isLeaf(Node node) {
        if(node == null) return false;
        return node.left == null && node.right == null;
    }
    private  void printList() {
        Node itr = head;
        while(itr != null) {
            System.out.print(itr);
            itr= itr.right;
        }
        System.out.println();
    }
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
        ExtractLeafInDLL dll = new ExtractLeafInDLL();
        //Get all Leafs from tree into this list from left to right
        dll.extractLeafs(root);
        System.out.println("List");
        dll.printList();

        //Print Tree to make sure that leafs are gone
        System.out.println("\nTree");
        Utility.levelOrderLineByLine(root);
    }

}
