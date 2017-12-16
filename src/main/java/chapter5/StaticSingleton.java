package chapter5;

/**
 * Created by 13 on 2017/5/6.
 */
public class StaticSingleton {
    private StaticSingleton() {
        System.out.println("StaticSingle is create");
    }

    private static class SingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }

    public static void main(String args[]) {
        StaticSingleton a1 = StaticSingleton.getInstance();
        StaticSingleton a2 = StaticSingleton.getInstance();
        System.out.println(a1 == a2);
        StaticSingleton a3 = new StaticSingleton();
        System.out.println(a3 == a2);
    }
}
