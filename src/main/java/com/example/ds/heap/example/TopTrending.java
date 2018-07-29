package com.example.ds.heap.example;


public class TopTrending {
    public static void main(String[] args) {
        Heap heap = new Heap();
        int[] topics = new int[]{1, 3, 1, 3, 2, 2, 2};
        //Testing Offer
        for(int topic : topics)heap.offer(topic);
        Topic topic = null;
        //Testing Poll
        while((topic = heap.poll()) != null) {
            System.out.println(topic);
        }

        //Test Top Trending
        for(int t : topics){
            heap.offer(t);
            System.out.println("Trending:"+heap.peek());
        }



    }
}
