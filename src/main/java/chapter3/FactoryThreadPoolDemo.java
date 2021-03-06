package chapter3;

import java.util.concurrent.*;

/**
 * Created by 13 on 2017/5/5.
 */
public class FactoryThreadPoolDemo {
    public static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":Thread ID:" + Thread.currentThread().getId());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        MyTask myTask = new MyTask();

        ExecutorService executorService
            = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new ThreadFactory() {

                @Override
                public Thread newThread(Runnable r) {
                    Thread t = new Thread(r);
                    t.setDaemon(true);
                    System.out.println("create " + t);
                    return t;
                }

            });

        for (int i = 0; i < 100; i++) {
            executorService.submit(myTask);
            Thread.sleep(10);
        }
    }
}
