package com.example.misc.design.proxy;


public class LoginServiceImpl implements LoginService {

    @Override
    public void logIn(String user, String pass) {
        System.out.println("Fetching record for user "+ user+ " with password "+pass);
    }
}
