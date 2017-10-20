package com.example.misc.design.proxy;


public class TestProxy {
    public static void main(String[] args) {
        LoginService service = LoginServiceFactory.getLoginBean();
        service.logIn("Ravi","Stromborn");
    }
}
