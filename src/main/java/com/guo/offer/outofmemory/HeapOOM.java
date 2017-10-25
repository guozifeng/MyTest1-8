package com.guo.offer.outofmemory;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args£º-Xms10m -Xmx10m -XX:+HeapDumpOnOutOfMemoryError -verbose:gc -XX:+PrintGCDetails
 * @author zzm
 */
public class HeapOOM {

	static class OOMObject {
	}

	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();

		while (true) {
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list.add(new OOMObject());
		}
	}
}