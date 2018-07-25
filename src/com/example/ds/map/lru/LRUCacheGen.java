package com.example.ds.map.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheGen<E, V> {
    private int size;
    private Map<E, Node> map = new HashMap<>();

    public LRUCacheGen(int size) {
        this.size = size;
    }

    void put(E e, V v) {
        if(!map.containsKey(e)) {
            if(map.size() == size){
                map.remove(head.key);
                deleteFirst();
            }

            Node node = new Node(e, v);
            map.put(e, node);
            addLast(node);
        } else {
            Node node = map.get(e);
            node.value = v;
            deleteNode(node);
            addLast(node);
        }
    }

    V get(E e) {
        if(map.containsKey(e)) {
            Node node = map.get(e);
            deleteNode(node);
            addLast(node);
            return (V)node.value;
        }
        return null;
    }

    private static class Node<E,V> {
        E key;
        V value;
        Node next;
        Node prev;

        Node(E key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    Node head = null;
    Node tail = head;
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

    private void deleteFirst() {
        if(head == null) return;
        else if(head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    @Override
    public String toString() {
        Node node = head;
        StringBuilder sb = new StringBuilder();
        while(node != null) {
            sb.append("[" + node.key + "," +node.value+"]").append(" ");
            node = node.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LRUCacheGen<Integer, Integer> cache = new LRUCacheGen<>(2);
        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);

        System.out.println(cache.get(1));;

        System.out.println(cache.get(2));

    }
}
