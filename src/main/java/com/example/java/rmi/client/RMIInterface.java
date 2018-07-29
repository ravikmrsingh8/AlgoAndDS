package com.example.java.rmi.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {
    String sayHello(String name) throws RemoteException;
}
