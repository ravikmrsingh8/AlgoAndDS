package com.example.design.objectpool;

public class ConnectionImpl implements Connection {
    @Override
    public void close() {
        System.out.println(" Closing connection");
    }

    @Override
    public String metadata() {
        return "Oracle Connection";
    }
}
