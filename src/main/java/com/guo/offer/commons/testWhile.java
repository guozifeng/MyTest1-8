package com.guo.offer.commons;

public class testWhile {
	public static void main(String[] args) {
	    int i = 0;
		while(true) {
		    i++;
		    System.out.println("================="+i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                 e.printStackTrace();
            }
            if(i == 50){
                break;
            }
        }
	}
}
