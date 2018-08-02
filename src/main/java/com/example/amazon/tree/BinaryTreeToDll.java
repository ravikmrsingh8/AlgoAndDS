package com.example.amazon.tree;


public class BinaryTreeToDll {

    public static void main(String[] args) {
        Node root        = new Node(10);
        root.left        = new Node(12);
        root.right       = new Node(15);
        root.left.left  = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);
        System.out.println("Tree");
        Utility.levelOrderLineByLine(root);

        System.out.println("List :");
        Node head = toDLL(root);
        printList(head);

    }

    static Node toDLL(Node root){
        if(root == null) return null;
        return toDLL0(root).head;
    }

    static Pair toDLL0(Node root){
        if(root == null) return new Pair(null, null);
        Pair list1 = toDLL0(root.left);
        Pair list2 = toDLL0(root.right);
        return append(list1, root, list2);
    }

    static Pair append(Pair list1, Node root, Pair list2 ){
        root.left = list1.tail;
        root.right = list2.head;
        if(list1.head == null && list2.head == null){
            return new Pair(root, root);
        } else if(list1.head == null){
            list2.head.left = root;
            return new Pair(root, list2.tail);
        } else if(list2.head == null) {
            list1.tail.right = root;
            return new Pair(list1.head, root);
        } else {
            list1.tail.right = root;
            list2.head.left = root;
            return new Pair(list1.head, list2.tail);
        }
    }


    static void printList(Node head){
        while(head!= null){
            System.out.print(head.data+" ");
            head = head.right;
        }
    }

    static class Pair {
        Node head;
        Node tail;

        public Pair(Node head, Node tail) {
            this.head = head;
            this.tail = tail;
        }
    }

}
