package com.guo.parallelbook.chapter4;

/**
 * 
 * ��������Կ�����һ��threadLocal��ǿ���öϿ���key���ڴ�Ϳ��Եõ��ͷš�ֻ�е��߳̽�����value���ڴ���ͷš� * 
 * ÿ��thread�ж�����һ��map��
 * map��������ThreadLocal.ThreadLocalMap��Map�е�keyΪһ��threadlocalʵ����
 * ���Map��ȷʹ���������ã�����������ֻ�����key��ÿ��key��������ָ��threadlocal��
 * ����threadlocalʵ����Ϊnull�Ժ�û���κ�ǿ����ָthreadlocalʵ��������threadlocal���ᱻgc���ա�
 * ���ǣ����ǵ�valueȴ���ܻ��գ���Ϊ����һ����current
 * thread���ӹ�����ǿ���á�
 * 
 * ֻ�е�ǰthread�����Ժ�, current thread�Ͳ������ջ��,ǿ���öϿ�, 
 * Current Thread, Map, value��ȫ����GC����.
 * 
 * @author Administrator
 * @date 2018/01/13
 * 
 */
public class ThreadLocalTest3 {
    public static class MyThreadLocal extends ThreadLocal {
        private byte[] a = new byte[1024 * 1024 * 1];

        @Override
        public void finalize() {
            System.out.println("My threadlocal 1 MB finalized.");
        }
    }

    public static class My50MB {// ռ���ڴ�Ĵ����
        @Override
        public String toString() {
            return "My50MB [a=" + 1111 + "]";
        }

        private byte[] a = new byte[1024 * 1024 * 50];

        @Override
        public void finalize() {
            System.out.println("My 50 MB finalized.");
        }
        
        
    }

    public static void main(String[] args) throws InterruptedException {
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadLocal tl = new MyThreadLocal();
                tl.set(new My50MB());
                System.out.println(tl.get());
                
                tl.remove();
                
                tl = null;// �Ͽ�ThreadLocal��ǿ����
                //System.out.println(tl.get());
                System.out.println("Full GC 1");
                System.gc();

            }

        }).start();

        //Thread.sleep(1000);
        System.out.println("Full GC 2");
        System.gc();
        Thread.sleep(1000);
        System.out.println("Full GC 3");
        System.gc();
        Thread.sleep(1000);
        System.out.println("Full GC 4");
        System.gc();
        Thread.sleep(1000);

    }
}