package com.guo.offer.proxy;

public class ProxyTest {

    public static void main(String[] args) {
        // ʵ����Ŀ�����
        Subject userService = new SubjectImpl();
        // ʵ����InvocationHandler
        //ProxyHandler invocationHandler = new ProxyHandler(userService);
        // ����Ŀ��������ɴ������
        //Subject proxy = (Subject) invocationHandler.getProxy();
        
        Subject proxy =(Subject) JDKProxy.getPoxyObject(userService);
        // ���ô������ķ���
        proxy.add();
        
    }

}
