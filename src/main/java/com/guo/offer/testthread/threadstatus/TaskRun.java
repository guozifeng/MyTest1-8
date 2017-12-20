package com.guo.offer.testthread.threadstatus;

import java.util.concurrent.CompletableFuture;

// ����CompletableFuture��Ϊ�乹�캯��
// ����CompletableFuture��ʾ��������ƽ������ӡ��
class TaskRun implements Runnable {

    CompletableFuture<Integer> cf = null;

    public TaskRun(CompletableFuture<Integer> cf) {
        this.cf = cf;
    }

    @Override
    public void run() {
        int tmp = 0;
        try {
            tmp = cf.get() * cf.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(tmp);
    }
}
