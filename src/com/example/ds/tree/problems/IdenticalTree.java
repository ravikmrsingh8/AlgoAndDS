package com.example.ds.tree.problems;
/*=================================================
       45              45                    45
     /    \          /   \                  /   \
    35    60        35    60               60     35
   / \    /        /  \    /                \    /  \
  20  38 50       20   38  50               50  38   20


 ==================================================*/


public class IdenticalTree {
    public static void main(String[] args) {
        //Tree1
        Node root1 = new Node(45);
        root1.left = new Node(35);
        root1.left.left = new Node(20);
        root1.left.right = new Node(38);
        root1.right = new Node(60);
        root1.right.left = new Node(50);

        //Tree 2
        Node root2 = new Node(45);
        root2.left = new Node(35);
        root2.left.left = new Node(20);
        root2.left.right = new Node(38);
        root2.right = new Node(60);
        root2.right.left = new Node(50);


        //Tree 3
        Node root3 = new Node(45);
        root3.left = new Node(60);
        root3.left.right = new Node(50);
        root3.right = new Node(35);
        root3.right.left = new Node(38);
        root3.right.right = new Node(20);


        System.out.println("Tree1");
        Utility.levelOrderLineByLine(root1);


        System.out.println("Tree2");
        Utility.levelOrderLineByLine(root1);


        System.out.println("Tree3");
        Utility.levelOrderLineByLine(root1);

        System.out.println("Tree1 == Tree2: " + isIdentical(root1, root2));
        System.out.println("Tree1 == Tree3: " + isIdentical(root1, root3));
    }

    static boolean isIdentical(Node root1, Node root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null) return false;
        if(root2 == null) return false;
        return root1.data == root2.data
                && isIdentical(root1.left, root2.left)
                && isIdentical(root1.right, root2.right);
    }

}
