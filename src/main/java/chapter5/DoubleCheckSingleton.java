package chapter5;

public class DoubleCheckSingleton {
    
    static String a ="aa";
    
    static {
        System.out.println("DoubleCheckSingletonDoubleCheckSingleton");
    }
    
    private volatile static DoubleCheckSingleton singleton;

    private DoubleCheckSingleton() {
        System.out.println("DoubleCheckSingleton is create");
    }

    public static DoubleCheckSingleton getSingleton() {
        if (singleton == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (singleton == null) {
                    singleton = new DoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }

}
