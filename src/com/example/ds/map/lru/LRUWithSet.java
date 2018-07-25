package com.example.ds.map.lru;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class LRUWithSet {
    Map<Integer, Node> map = new HashMap<>();
    Set<Node>  nodes ;
    int size;
    LRUWithSet(int N){
        this.size = N;
        nodes = new LinkedHashSet<>(N);

    }

    void set(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            nodes.remove(node);
            node.value = value;
            nodes.add(node);
        } else {
            if(size == map.size()) {
                Node firstNode = nodes.iterator().next();
                map.remove(firstNode.key);
                nodes.remove(firstNode);
            }
            Node node = new Node(key, value);
            nodes.add(node);
            map.put(key, node);
        }
    }
    int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            nodes.remove(node);
            nodes.add(node);
            return node.value;
        }
        return -1;
    }
    static class Node {
        int key;
        int value;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUWithSet cache = new LRUWithSet(2);
        cache.set(2,1);
        cache.set(1,1);
        cache.set(2,3);
        cache.set(4,1);

        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
