package com.guo.parallelbook.chapter2;

/**
 * Created by 13 on 2017/5/4.
 */
public class InterruptAndStopThread {
    public static void main(String args[]) throws InterruptedException {

        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("收到中断信号,停止该线程!");
                        break;
                    }
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("11收到中断信号,停止该线程!");
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("Running!");
                    Thread.yield();
                }
            }
        };

        thread.start();
        Thread.sleep(2000);
        thread.interrupt();// 进行中断操作
    }
}
