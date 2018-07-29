package com.example.ds.heap.example;


import java.util.*;

public class Heap {
    private List<Topic> topics = new ArrayList<>();
    //map topic id to its index in heap
    private Map<Integer, Integer> indexes = new HashMap<>();

    public Heap() {
    }

    public void offer(int data) {
        int idx = -1;
        if (indexes.containsKey(data)) {
            idx = indexes.get(data);
            Topic topic = topics.get(idx);
            topic.count++;
        } else {
            Topic topic = new Topic(data);
            topics.add(topic);
            idx = topics.size() - 1;
        }
        percolateUp(idx);

    }

    public Topic peek() {
        if (topics.size() == 0) return null;
        return topics.get(0);
    }

    public Topic poll() {
        if (topics.size() == 0) return null;
        Topic topic = topics.get(0);
        Topic lastTopic = topics.get(topics.size() - 1);
        topics.set(0, lastTopic);
        topics.remove(topics.size() - 1);

        indexes.remove(topic.id);
        heapify(0);

        return topic;
    }

    public Topic delete(int id) {
        if (!indexes.containsKey(id)) return null;
        int index = indexes.get(id);
        Topic topic = topics.get(index);
        topic.count = Integer.MAX_VALUE;
        percolateUp(index);
        poll();
        indexes.remove(id);
        return topic;
    }

    private void heapify(int idx) {
        int left = left(idx);
        int right = right(idx);
        int topic = idx;
        if (left < topics.size() && compare(topics.get(left), topics.get(topic)) < 0) topic = left;
        if (right < topics.size() && compare(topics.get(right), topics.get(topic)) < 0) topic = right;
        if (topic != idx) {
            Collections.swap(topics, topic, idx);
            indexes.put(topics.get(topic).id, topic);
            indexes.put(topics.get(idx).id, idx);
            heapify(topic);
        }
    }

    private void percolateUp(int idx) {
        Topic topic = topics.get(idx);
        while (idx > 0 && compare(topic, topics.get(parent(idx))) < 0) {
            topics.set(idx, topics.get(parent(idx)));
            indexes.put(topics.get(parent(idx)).id, idx);
            idx = parent(idx);
        }
        topics.set(idx, topic);
        indexes.put(topic.id, idx);
    }

    private int compare(Topic a, Topic b) {
        if (a.count > b.count) return -1;                  // if count is more it will go up
        else if (a.count == b.count) return b.id - a.id; // return latest one (i.e topics with latest id)
        else return 1;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

}
