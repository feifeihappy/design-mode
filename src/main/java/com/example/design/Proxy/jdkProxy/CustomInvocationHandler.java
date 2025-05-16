package com.example.design.Proxy.jdkProxy;

import java.lang.reflect.Method;

/**
* JDK代理类生成
*/
public class CustomInvocationHandler implements MyInvocationHandler {
    private IPerson target;
    public IPerson getInstance(IPerson target){
        this.target = target;
        Class<?> clazz =  target.getClass();
        return (IPerson) MyProxy.newProxyInstance(new MyClassLoader(),clazz.getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(this.target,args);
        after();
        return result;
    }

    private void before() {
        System.out.println("事前做好计划");
    }
    
    private void after() {
        System.out.println("事后回顾梳理");
    }

}