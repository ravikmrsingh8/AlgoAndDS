package com.example.ds.tree;
/*==============================================================
*         10                          6                     9
*       /   \                       /   \                  / \
*      8     2                     4     5    ----->     4    5
*     / \     \                   / \     \             / \    \
*    3  5      2                 1   2     3           2   2    5
*==============================================================*/

public class ChildrenSumProperty {
    public static void main(String[] args) {
        //Tree1
        Node root1 = new Node(10);
        root1.left = new Node(8);
        root1.right = new Node(2);
        root1.left.left = new Node(3);
        root1.left.right = new Node(5);
        root1.right.right = new Node(2);

        System.out.println("Tree1");
        Utility.levelOrderLineByLine(root1);
        System.out.println("Children Sum Property for Tree1: " + childrenSumProperty(root1));

        root1 = new Node(6);
        root1.left = new Node(4);
        root1.right = new Node(5);
        root1.left.left = new Node(1);
        root1.left.right = new Node(2);
        root1.right.right = new Node(3);
        System.out.println("Tree1");
        Utility.levelOrderLineByLine(root1);
        System.out.println("Converted Tree : ");
        convertToChildrenSumTree(root1);
        Utility.levelOrderLineByLine(root1);
    }

    private static boolean childrenSumProperty(Node root) {
        if (root == null) return true;
        else if (isLeaf(root)) return true;
        else {
            int leftData = root.left != null ? root.left.data : 0;
            int rightData = root.right != null ? root.right.data : 0;
            return root.data == leftData + rightData
                    && childrenSumProperty(root.left)
                    && childrenSumProperty(root.right);
        }
    }

    private static boolean isLeaf(Node root) {
        if (root == null) return false;
        return root.left == null && root.right == null;
    }

    private static Node convertToChildrenSumTree(Node root) {
        if(root == null) return null;
        else if(isLeaf(root)){
            return root;
        } else {
            convertToChildrenSumTree(root.left);
            convertToChildrenSumTree(root.right);
            int data = 0;
            if(root.left != null) data += root.left.data;
            if(root.right != null) data += root.right.data;
            if(root.data <= data ) root.data = data;
            else {
                increment(root, root.data - data);
            }
            return root;
        }
    }
    private static void increment(Node root, int data) {
        if(root.left !=  null) {
            root.left.data += data;
            increment(root.left,data);
        } else if(root.right != null) {
            root.right.data += data;
            increment(root.right, data);
        }
    }
}
