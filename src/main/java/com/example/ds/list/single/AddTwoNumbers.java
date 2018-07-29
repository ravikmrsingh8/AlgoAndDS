package com.example.ds.list.single;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Node num1 = getNum(new int[]{0,0,0,0});
        Node num2 = getNum(new int[]{1});
        Node sum = add(num1, num2);

        System.out.println("Sum: ");
        Utility.printList(sum);

    }

    static Node add(Node num1, Node num2) {
        int sum = 0;
        int carry = 0;
        Node head = new Node(Integer.MAX_VALUE);
        Node tail = head;
        while (num1 != null || num2 != null) {
            int a = num1 == null ? 0 : num1.data;
            int b = num2 == null ? 0 : num2.data;

            sum = a + b + carry;
            carry = sum / 10;
            sum = sum % 10;

            tail.next = new Node(sum);
            tail = tail.next;
            if (num1 != null) num1 = num1.next;
            if (num2 != null) num2 = num2.next;
        }

        if(carry > 0) tail.next = new Node(carry);
        return head.next;
    }




    static Node getNum(int[] arr) {
        Node head = new Node(Integer.MAX_VALUE);
        Node tail = head;
        for (int i = arr.length - 1; i >= 0; i--) {
            tail.next = new Node(arr[i]);
            tail = tail.next;
        }
        return head.next;
    }
}
