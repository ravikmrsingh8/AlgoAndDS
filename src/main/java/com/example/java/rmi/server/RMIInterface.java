package com.example.java.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {
    String sayHello(String name) throws RemoteException;
}
