package chapter5;

/**
 * @author Administrator
 * @date 2017/12/16
 */
public class SingletonMainTest {

    public static void main(String args[]) {
        StaticSingleton a1 = StaticSingleton.getInstance();
        StaticSingleton a2 = StaticSingleton.getInstance();
        System.out.println(a1 == a2);
        
        DoubleCheckSingleton a3 = DoubleCheckSingleton.getSingleton();
        DoubleCheckSingleton a4 = DoubleCheckSingleton.getSingleton();
        System.out.println(a3 == a4);
    }

}
