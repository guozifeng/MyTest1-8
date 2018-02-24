package com.guo.offer.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy {
    public static Object getPoxyObject(final Object c) {
        return Proxy.newProxyInstance(c.getClass().getClassLoader(), c.getClass().getInterfaces(),// JDKʵ�ֶ�̬������JDKʵ�ֱ�����Ҫ�ӿ�
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object reObj = null;
                        System.out.println("------------------before------------------");
                        // ִ��Ŀ�����ķ���
                        reObj = method.invoke(c, args);
                        // ��Ŀ�����ķ���ִ��֮��򵥵Ĵ�ӡһ��
                        System.out.println("-------------------after------------------");
                        return reObj;
                    }
                });

    }
}
