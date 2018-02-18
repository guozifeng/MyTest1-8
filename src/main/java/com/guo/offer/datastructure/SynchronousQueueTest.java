package com.guo.offer.datastructure;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * ����ʹ��SynchronousQueueģ�⣺ ���ֻ��һ����Ʒ��������-������ģ��
 * 
 * �������߳��� ����������Ѳ�Ʒ �������߳��� ���������Ʒ��
 * 
 * @author maguowei01
 * 
 */
public class SynchronousQueueTest {
    public static void main(String[] args) {
        // true��֤�������������߳���FIFO��˳����ʡ�
        SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>(true);
        for (int i = 0; i < 1; ++i) {
            //new Customer(queue).start();
        }
        for (int i = 0; i < 1; ++i) {
            new Product(queue).start();
        }
    }

    static class Product extends Thread {
        SynchronousQueue<Integer> queue;

        public Product(SynchronousQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                int rand = new Random().nextInt(1000);
                
                System.out.println("Thread Id11:" + getId() + " �ȴ���������ͳ�ȥ...");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                /*
                 * offer()��queue���һ��element���������أ�����������element����һ��threadȡ���ˣ�
                 * offer��������true����Ϊoffer�ɹ������򷵻�false��
                 * Ҳ����˵offer��һ�������Ĳ���Ķ����У��϶�û�ɹ���ʧ��
                 */

                //queue.offer(rand); //ע��offer��put����������
                //System.out.println("Thread Id:" + getId() + "  ������һ����Ʒ��" + rand + "   " + queue.offer(rand));
                try {
                     
                     // put()��queue�Ž�ȥһ��element�Ժ��һֱwaitֱ��������thread���������elementȡ�ߡ�
                     
                    queue.put(rand);
                    System.out.println("Thread Id:" + getId() + "  ������һ����Ʒ��" + rand);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Customer extends Thread {
        SynchronousQueue<Integer> queue;

        public Customer(SynchronousQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    // �߳����е�queue.take()������ֱ��Product����һ����Ʒqueue.offer��
                    System.out.println("Thread Id:" + getId() + " ������һ����Ʒ:" + queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("-------------------Customer-----------------------");
            }
        }
    }
}