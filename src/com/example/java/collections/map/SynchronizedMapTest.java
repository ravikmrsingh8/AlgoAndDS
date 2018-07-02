package com.example.java.collections.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SynchronizedMapTest {
    public static void main(String[] args) throws InterruptedException {

        Map<Integer, String> map = Collections.synchronizedMap(new HashMap<>());
        map.put(1,"One");
        map.put(2,"Two");
        map.put(3,"Three");
        map.put(null, null);
        map.put(4, null);
        System.out.println(map);

        Thread.sleep(2000);
        new Thread(()->{
            int i = 4;
            while(true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                map.put(++i, ""+i);
            }
        }).start();


        new Thread(()->{
            for(Integer key : map.keySet()){
                System.out.println(map.get(key));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
