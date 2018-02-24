package com.guo.offer.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler implements InvocationHandler {
    // Ŀ�����
    private Object target;

    /**
     * ���췽��
     * 
     * @param target
     *            Ŀ�����
     */
    public ProxyHandler(Object target) {
        super();
        this.target = target;
    }

    /**
     * ִ��Ŀ�����ķ���
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // ��Ŀ�����ķ���ִ��֮ǰ�򵥵Ĵ�ӡһ��
        System.out.println("------------------before------------------");
        // ִ��Ŀ�����ķ���
        Object result = method.invoke(target, args);
        // ��Ŀ�����ķ���ִ��֮��򵥵Ĵ�ӡһ��
        System.out.println("-------------------after------------------");
        return result;
    }

    /**
     * ��ȡĿ�����Ĵ������
     * 
     * @return �������
     */
    public Object getProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
