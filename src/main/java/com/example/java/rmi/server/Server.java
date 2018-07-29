package com.example.java.rmi.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements RMIInterface {
    protected Server() throws RemoteException {
    }

    @Override
    public String sayHello(String name) {
        System.out.println(name + " is trying to connect");
        return "Hello " + name;
    }

    public static void main(String[] args) {
        try {
            Naming.rebind("//1FBLYX1J/Greeter", new Server());
            System.out.println("Server done");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
