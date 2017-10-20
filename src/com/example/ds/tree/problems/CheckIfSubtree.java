package com.example.ds.tree.problems;
/*===============================================
  Tree 1                        Tree2
              26                   10
            /   \                 /  \
          10     3              4     6
        /    \     \            \
      4       6      3           30
       \
        30
 =================================================*/

public class CheckIfSubtree {
    public static void main(String[] args) {
        Node root1 = new Node(26);
        root1.right = new Node(3);
        root1.right.right = new Node(3);
        root1.left = new Node(10);
        root1.left.left = new Node(4);
        root1.left.left.right = new Node(30);
        root1.left.right = new Node(6);

        Node root2 = new Node(10);
        root2.right = new Node(6);
        root2.left = new Node(4);
        root2.left.right = new Node(30);

        System.out.println("IsSubtree "+isSubTree(root1, root2));
    }
    static boolean isSubTree(Node root, Node subTreeRoot){
        if(isIdentical(root,subTreeRoot)) return true;
        else return isIdentical(root.left,subTreeRoot) || isIdentical(root.right, subTreeRoot);
    }
    static boolean isIdentical(Node root1, Node root2){
        //System.out.println("comparing "+root1+", "+root2);
        if(root1 == null && root2 == null) return true;
        else if(root1 == null || root2 == null) {
            return false;
        } else {
            return root1.data == root2.data
                    && isIdentical(root1.left, root2.left)
                    && isIdentical(root1.right, root2.right);
        }
    }
}
