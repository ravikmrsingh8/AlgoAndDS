package com.example.ds.list.doublelist;

public class FlattenList {
    public static void main(String[] args) {
        FNode head = new FNode(5);
        head.down = new FNode(7);
        head.down.down = new FNode(8);
        head.down.down.down = new FNode(30);

        head.right = new FNode(10);
        head.right.down = new FNode(20);

        head.right.right = new FNode(19);
        head.right.right.down = new FNode(22);
        head.right.right.down = new FNode(50);

        head.right.right.right = new FNode(20);
        head.right.right.right.down = new FNode(30);
        head.right.right.right.down.down = new FNode(35);
        head.right.right.right.down.down.down = new FNode(40);
        head.right.right.right.down.down.down.down = new FNode(45);
        System.out.println("List");
        Utilty.printList(head);
        System.out.println("Flattening.....");
        //head = flatten(head);
        head = flattenRec(head);
        System.out.println("List ");
        Utilty.printDown(head);

    }

    static FNode flatten(FNode head) {
        if(head == null) return null;
        FNode nextNode = head.right;
        while(nextNode != null){
            head = merge(head,nextNode);
            nextNode = nextNode.right;
        }
        return head;
    }

    static FNode flattenRec(FNode head) {
        if(head == null) return null;
        if(head.right == null) return head;
        FNode newHead = merge(head, head.right);
        newHead.right = head.right.right;
        return flatten(newHead);
    }
    static FNode merge(FNode f1, FNode f2) {
        if(f1 == null) return f2;
        if(f2 == null) return f1;
        FNode newHead = new FNode(Integer.MAX_VALUE);
        FNode temp = newHead;
        while(f1 != null && f2 != null) {
            if(f1.data < f2.data) {
                temp.down = f1;
                f1 = f1.down;
            } else {
                temp.down = f2;
                f2 = f2.down;
            }
            temp = temp.down;
        }
        if(f1 != null) temp.down = f1;
        if(f2 != null) temp.down = f2;
        return newHead.down;
    }
}
