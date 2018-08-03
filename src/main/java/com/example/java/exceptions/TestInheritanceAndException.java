package com.example.java.exceptions;


import java.io.IOException;

public class TestInheritanceAndException {
    public static void main(String[] args) {
        A a = new A();
        a.test();

        System.out.println(10.0/-0);
        System.out.println(-10.0/0);
    }

}


class A{
    A() {
        System.out.println("A");
        //throw  new IOException("from A");
    }

    Void foo(int a){
       return null;
    }
    private boolean flag = true;

    void test(){
        new Inner().foo();
    }

    class Inner {
        void foo(){
            System.out.println(A.this.flag);
            System.out.println("Foo");
        };
    }

}


class B extends A{
    B() throws Exception{
        try{
            //super();  won't allow as super has to be first statement
            throw new IOException("from B");
        } catch(IOException e){

        }

    }
}