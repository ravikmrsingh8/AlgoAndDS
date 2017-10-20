package com.example.ds.list.single;

public class List {
    Node head;
    int N;
    void add(int data) {
        N++;
        Node node = new Node(data);
        if(head == null) {
            head = node;
            return;
        }
        Node itr = head;
        while(itr.next != null) itr = itr.next;
        itr.next = node;
    }

    void add(int index, int data) {
        if(index < 0 || index >N) {
            throw new IndexOutOfBoundsException("Invalid index: "+index);
        }

        N++;
        Node node = new Node(data);
        if(index == 0) {
            node.next = head;
            head = node;
            return;
        }

        Node itr = head;
        int i = 0;
        for (;i<index -1 ;i++) itr = itr.next;
        node.next = itr.next;
        itr.next = node;
    }
    public int length(){
        return length(head);
    }
    private int length(Node head) {
        if(head == null) return 0;
        return 1 + length(head.next);
    }

    void delete(int data) {
        if(head == null) {
            return;
        }

        if(data == head.data) {
            head = head.next;
            return;
        }

        Node prevNode = head;
        Node curNode = head.next;
        while(curNode != null && curNode.data != data) {
            prevNode.next = curNode.next;
        }
        if(curNode == null) return;
        prevNode.next = curNode.next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node curr = head;
        while(curr != null) {
            sb.append(curr.data);
            if(curr.next != null){
                sb.append(", ");
            }
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }


    public static void main(String[] args) {
        List list = new List();
        System.out.println(list);
        list.add(4);list.add(48);list.add(3);list.add(67);list.add(89);
        System.out.println(list+".length(): "+list.length()+"\n");

        list.add(0, 23);list.add(0,34);
        System.out.println(list);

        list.add(7,89);list.add(6,78);
        System.out.println(list);

        list= new List();
        //list.add(1,9);
        list.add(0,23);
        System.out.println(list);


        list = new List();
        list.delete(78);
        System.out.println(list);

        list.add(5);list.add(45);list.add(4);
        System.out.println(list);
        list.delete(45);
        System.out.println(list);
        list.delete(5);
        System.out.println(list);
        list.delete(4);
        System.out.println(list);

    }
}
