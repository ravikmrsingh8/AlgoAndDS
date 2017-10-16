package com.example.ds.tree.problems;
/*=========================================================
              1
            /   \
          2      3
        /  \
      4     5
     /
    7

 =========================================================*/

public class AllAncestors {
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
        printAllAncestors(root,7);
    }

    private static void printAllAncestors(Node root,int i) {
        preOrder(root, i,new Node[1000],0);
    }

    private static boolean preOrder(Node root, int i, Node[] path, int level) {
        //System.out.println("processing "+ ((root!= null)?root: "null"));
        if(root == null) return false;
        else if(root.data == i) {
            printPath(path, level);
            return true;
        } else {
            path[level] = root;
            return  preOrder(root.left,i,path,level+1)
                    || preOrder(root.right,i,path,level+1);

        }
    }

    private static void printPath(Node[] path, int N) {
        for(int i=0;i<N; i++) System.out.print(path[i]+"\t");
    }
}
