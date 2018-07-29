package com.example.design.proxy;


public class LoginServiceImpl implements LoginService {

    @Override
    public Object logIn(String user, String pass) {
        System.out.println("Fetching record for user "+ user+ " with password "+pass);
        return new Object(){
            @Override
            public String toString() {
                return "User: "+ user + " Pass: "+pass;
            }
        };
    }
}
