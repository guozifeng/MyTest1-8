package com.guo.offer.proxy;

public class ProxyTest {

    public static void main(String[] args) {
        // 实例化目标对象
        Subject userService = new SubjectImpl();
        // 实例化InvocationHandler
        //ProxyHandler invocationHandler = new ProxyHandler(userService);
        // 根据目标对象生成代理对象
        //Subject proxy = (Subject) invocationHandler.getProxy();
        
        Subject proxy =(Subject) JDKProxy.getPoxyObject(userService);
        // 调用代理对象的方法
        proxy.add();
        
    }

}
