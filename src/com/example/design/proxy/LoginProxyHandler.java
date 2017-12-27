package com.example.design.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoginProxyHandler implements InvocationHandler {
    private LoginService loginService;
    public LoginProxyHandler(LoginService service) {
        this.loginService = service;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Going out with Emilia clarke");
        System.out.println("Taking permission from Bill Gates");
        System.out.println("User: "+args[0]);
        System.out.println("Password: "+args[1]);
        args[0] = ((String)args[0]).toLowerCase();
        System.out.println("Changing UserId in small cases: "+args[0]);
        return method.invoke(loginService,args);

    }
}
