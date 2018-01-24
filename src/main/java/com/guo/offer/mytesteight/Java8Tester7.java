package com.guo.offer.mytesteight;

/**
 * 
 * @author Administrator
 * @date 2017/12/07
 */
public class Java8Tester7 {
    public static void main(String args[]) {
        Java8Tester7 tester = new Java8Tester7();

        /**
         * 
         */
        MathOperation addition = (int a1, int b1) -> a1 + b1;

        MathOperation subtraction = (a, b) -> a - b;

        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        GreetingService greetService1 = message -> System.out.println("Hello " + message);

        GreetingService greetService2 = (message) -> System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");
    }

    /**
     * 
     * @author Administrator
     * @date 2017/12/07
     */
    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}