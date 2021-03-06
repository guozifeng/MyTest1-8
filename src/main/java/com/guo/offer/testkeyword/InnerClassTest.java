package com.guo.offer.testkeyword;

public class InnerClassTest {
    public static void main(String[] args) {
        // 初始化Bean1
        InnerClassTest test = new InnerClassTest();

        InnerClassTest.Bean1 bean1 = test.new Bean1();
        System.out.println(++bean1.I);

        // 初始化Bean2
        InnerClassTest.Bean2 bean2 = new InnerClassTest.Bean2();
        System.out.println(++bean2.J);

        // 初始化Bean3
        Bean bean = new Bean();
        Bean.Bean3 bean3 = bean.new Bean3();
        System.out.println(++bean3.k);
    }

    class Bean1 {
        public int I = 0;
    }

    static class Bean2 {
        public int J = 0;
    }
}

class Bean {
    class Bean3 {
        public int k = 0;
    }
}