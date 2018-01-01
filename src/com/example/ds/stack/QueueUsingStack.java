package com.example.ds.stack;

import java.util.Stack;

public class QueueUsingStack {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    public Integer poll(){
        if(!stack2.isEmpty()) return stack2.pop();
        if(stack2.isEmpty() && !stack1.isEmpty()){
            while(!stack1.isEmpty())stack2.push(stack1.pop());
            return stack2.pop();
        }
        return null;
    }
    public void offer(int data){
        stack1.push(data);
    }
    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }
    public static void main(String[] args) {
        QueueUsingStack q = new QueueUsingStack();
        q.offer(10);
        q.offer(20);
        q.offer(30);
        q.offer(40);
        q.offer(50);
        while(!q.isEmpty()){
            System.out.print(q.poll()+"\t");
        }
    }
}
