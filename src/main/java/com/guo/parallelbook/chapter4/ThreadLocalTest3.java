package com.guo.parallelbook.chapter4;

/**
 * 
 * 从输出可以看出，一旦threadLocal的强引用断开，key的内存就可以得到释放。只有当线程结束后，value的内存才释放。 * 
 * 每个thread中都存在一个map，
 * map的类型是ThreadLocal.ThreadLocalMap。Map中的key为一个threadlocal实例。
 * 这个Map的确使用了弱引用，不过弱引用只是针对key。每个key都弱引用指向threadlocal。
 * 当把threadlocal实例置为null以后，没有任何强引用指threadlocal实例，所以threadlocal将会被gc回收。
 * 但是，我们的value却不能回收，因为存在一条从current
 * thread连接过来的强引用。
 * 
 * 只有当前thread结束以后, current thread就不会存在栈中,强引用断开, 
 * Current Thread, Map, value将全部被GC回收.
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

    public static class My50MB {// 占用内存的大对象
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
                
                tl = null;// 断开ThreadLocal的强引用
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