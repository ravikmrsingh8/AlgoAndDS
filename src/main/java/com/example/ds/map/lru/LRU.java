package com.example.ds.map.lru;

import java.util.HashMap;
import java.util.Map;


class LRU {
    private int size;
    Node head = null;
    Node tail = head;
    Map<Integer, Node> map = new HashMap<>();

    /*Inititalize an LRU cache with size N */
    public LRU(int N) {
        this.size = N;
    }

    /*Returns the value of the key x if present else returns -1 */
    public int get(int x) {

        Node node = map.get(x);
        if(node != null) {
            deleteNode(node);
            addLast(node);
            return node.value;
        }
        return -1;

    }

    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {

        if(!map.containsKey(x)) {
            if(map.size() == size) {
                map.remove(head.key);
                deleteNode(head);
            }
            Node node = new Node(x, y);
            addLast(node);
            map.put(x, node);
        } else {

            Node node = map.get(x);
            node.value = y;

            deleteNode(node);
            addLast(node);

        }
    }


    class Node {
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private void deleteNode(Node node) {
        if(head == null){
            return;
        } else if(head == tail && node == head) {
            head = null;
            tail = null;
        } else if(head == node) {
            head = head.next;
            head.prev = null;
        } else if(node == tail)  {
            tail = tail.prev;
            tail.next = null;
        } else  {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }

    }
    private void addLast(Node node) {
        if(head == null) {
            head = tail = node;
        } else {
            node.next = null;
            node.prev = tail;
            tail.next = node;

            tail = node;
        }
    }

    public static void main(String[] args) {
        LRU cache = new LRU(2);
        cache.set(2,1);
        cache.set(1,1);
        cache.set(2,3);
        cache.set(4,1);

        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

    }
}
