package com.example.ds.queue.pq;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        Node node = new Node(1);
        PriorityQueue<Node> pq = new PriorityQueue<>(16, Comparator.comparing(Node::getData));
        pq.add(node);
        node.data = 2;
        pq.add(node);
        node.data = 3;
        pq.add(node);

        System.out.println(pq.size());

        while(!pq.isEmpty()) {
            System.out.println(pq.poll().data);
        }

    }
}
