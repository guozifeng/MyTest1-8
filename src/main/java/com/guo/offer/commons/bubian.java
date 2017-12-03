package com.guo.offer.commons;

import java.util.Vector;

public class bubian {
	
	 private static Vector<Integer> vector = new Vector<Integer>();
	 private static int count =0;
	    public static void main(String[] args) {
	        while (true) {
	        	count++;
	            for (int i = 0; i < 10; i++) {
	                vector.add(i);
	            }

	            Thread removeThread = new Thread(new Runnable() {
	                @Override
	                public void run() {
	                    for (int i = 0; i < vector.size(); i++) {
	                        vector.remove(i);
	                    }
	                }
	            });
                
	            Thread printThread = new Thread(new Runnable() {
	                @Override
	                public void run() {
	                    for (int i = 0; i < vector.size(); i++) {
	                    	vector.get(i);
	                        
	                    }
	                }
	            });

	            System.out.println((count));
	            
	            removeThread.start();
	            printThread.start();

	            //不要同时产生过多的线程，否则会导致操作系统假死
	            while (Thread.activeCount() > 20);
	        }
	    }


}
