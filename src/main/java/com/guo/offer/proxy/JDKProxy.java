package com.guo.offer.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy {
    public static Object getPoxyObject(final Object c) {
        return Proxy.newProxyInstance(c.getClass().getClassLoader(), c.getClass().getInterfaces(),// JDK实现动态代理，但JDK实现必须需要接口
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object reObj = null;
                        System.out.println("------------------before------------------");
                        // 执行目标对象的方法
                        reObj = method.invoke(c, args);
                        // 在目标对象的方法执行之后简单的打印一下
                        System.out.println("-------------------after------------------");
                        return reObj;
                    }
                });

    }
}
