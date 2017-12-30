package com.example.ds.tree;

import com.example.ds.list.doublelist.DLL;
import com.example.ds.list.doublelist.DNode;

import java.util.LinkedList;
import java.util.Queue;

public class SortedDLLToBST {
    public static void main(String[] args) {
        DLL list = new DLL();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("LIST:");
        System.out.println(list);

        DNode head = list.head;
        DNode root = toTree(head);
        System.out.println("Tree");
        levelOrder(root);
    }


    static DNode toTree(DNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        DNode root = mid(head);
        root.prev = toTree(head);
        root.next = toTree(root.next);
        return root;
    }

    static DNode mid(DNode head) {
        DNode fp = head;
        DNode sp = head;
        while (fp != null && fp.next != null) {
            fp = fp.next.next;
            sp = sp.next;
        }
        if (sp.prev != null) sp.prev.next = null;
        if (sp.next != null) sp.next.prev = null;
        return sp;
    }

    static void levelOrder(DNode root) {
        if (root == null) return;
        Queue<DNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            DNode node = q.poll();
            if (node == null) {
                if (!q.isEmpty()) {
                    q.offer(null);
                    sb.append("\n");
                }
            } else {
                sb.append(node);
                if (node.prev != null) q.offer(node.prev);
                if (node.next != null) q.offer(node.next);
            }
        }
        System.out.print(sb);
    }
}
