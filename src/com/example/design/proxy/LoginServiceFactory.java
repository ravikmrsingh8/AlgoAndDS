package com.example.design.proxy;


import java.lang.reflect.Proxy;

public class LoginServiceFactory {
    public static LoginService getLoginBean(){
        LoginService service = new LoginServiceImpl();
        return (LoginService)Proxy.newProxyInstance(service.getClass().getClassLoader(),new Class<?>[]{LoginService.class}, new LoginProxyHandler(service));
    }
}
