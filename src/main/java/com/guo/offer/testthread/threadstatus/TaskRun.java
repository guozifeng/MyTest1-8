package com.guo.offer.testthread.threadstatus;

import java.util.concurrent.CompletableFuture;

// 接收CompletableFuture作为其构造函数
// 计算CompletableFuture表示的整数的平方并打印。
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
