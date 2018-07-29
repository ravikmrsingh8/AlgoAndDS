package com.example.ds.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<E, V> extends LinkedHashMap<E, V> {
    private int N;
    public LRUCache(int N){
        //maintains access order, get or put
        super(N,0.8f,true);
        this.N = N;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<E, V> eldest) {
        if(size() > N) return true;
        //return super.removeEldestEntry(eldest);
        return false;
    }
}
