package com.guo.offer.keyword;

/**
 * @author Administrator
 * @date 2018/02/22
 */
public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        for (Season s : Season.values()) {
            describe(s);
        }
    }
    /*public void describe(int s){
        //s变量不能超越边界，校验条件
        if(s >= 0 && s <4){
            switch(s){
                case Season.Spring:
                    System.out.println("Summer is very hot!");
                    break;
                case Season.Summer:
                    System.out.println("Winter is very cold!");
                    break;
            }
        }
    }*/

    public static void describe(Season s) {
        switch (s) {
            case Summer:
                System.out.println("Summer is very hot!");
                break;
            case Winter:
                System.out.println("Winter is very cold!");
                break;
        }
    }
}
