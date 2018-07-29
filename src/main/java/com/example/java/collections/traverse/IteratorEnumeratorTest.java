package com.example.java.collections.traverse;

import java.util.*;

public class IteratorEnumeratorTest {
    public static void main(String[] args) throws InterruptedException {

        //Iterators are fail fast
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Iterator<Integer> itr = list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
            itr.remove();
        }
        System.out.println(list);




        //Enumerators are Fail safe
        Vector<Integer> vec = new Vector<>();
        vec.add(1);
        vec.add(2);
        new Thread(()->{
            while(true){
                vec.add(24);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        Enumeration<Integer> ints = vec.elements();
        while(ints.hasMoreElements()){
            Thread.sleep(1000);
            System.out.println(ints.nextElement());
            //vec.add(23);
        }



    }
}
