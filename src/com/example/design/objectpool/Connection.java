package com.example.design.objectpool;

import java.sql.Statement;

public interface Connection {
    void close();
    String metadata();
}
