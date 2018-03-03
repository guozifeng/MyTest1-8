package com.guo.offer.thread.threadstatus;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableThreadTest implements Callable<Integer> {
    public static void main(String[] args) {
        CallableThreadTest ctt = new CallableThreadTest();
        FutureTask<Integer> ft = new FutureTask<Integer>(ctt);
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "++++��ѭ������i��ֵ" + i);
            if (i == 2) {
                new Thread(ft, "�з���ֵ���߳�").start();
            }
        }

        try {
            System.out.println("���̵߳ķ���ֵ��" + ft.isDone());
            System.out.println("���̵߳ķ���ֵ��" + ft.get());
            System.out.println("���̵߳ķ���ֵ��" + ft.isDone());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "----" + i);
        }
        return i;
    }
}