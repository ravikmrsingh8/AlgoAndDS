package com.example.java.serialization;

import java.io.*;
import java.util.Arrays;
class User implements Serializable{
    private String name;
    private int age;
    private long[] balls ;
    public User(){}
    public User(String name, int age){
        this.name = name;
        this.age = age;
        this.balls = new long[]{1,2};
    }

    public long[] getBalls(){
    	return balls;
    }
    public void setBalls(long[] balls) {
    	this.balls = balls;
    }
    public int getAge() {return age;}
    public String getName(){return name;}
    public void setName(String name){
    	this.name = name;
    }
    public void setAge(int age) {
    	this.age = age;
    }

    public String toString() {
        return name+ "," + age +"," +Arrays.toString(balls);
    }

    public static void main(String[] args) throws Exception {
        User user = new User("Shiva", 29);
        System.out.println(user);
        byte[] buf = new byte[1024];
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out =  new ObjectOutputStream(bos);
        out.writeObject(user);
        buf = bos.toByteArray();


        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf));

        User user2 = (User)in.readObject();
        System.out.println(user2);


       printBytes(buf);



    }

    static void printBytes(byte[] buf){
        StringBuilder sb = new StringBuilder("[");
        for (byte b: buf){
            sb.append(Integer.toHexString(0xFF & b)).append(",");
        }
        sb.append("]");
        System.out.println(sb);
    }
}