package com.example.design.proxy;


public class TestProxy {
    public static void main(String[] args) {
        LoginService service = LoginServiceFactory.getLoginBean();
        Object result = service.logIn("Ravi","Stromborn");
        System.out.println(result);
    }
}
