package com.example.java.rmi.client;

import com.example.java.rmi.server.RMIInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args) {
        try {
            RMIInterface greeter = (RMIInterface)Naming.lookup("//1FBLYX1J/Greeter");
            System.out.println(greeter.sayHello(args[0]));
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
