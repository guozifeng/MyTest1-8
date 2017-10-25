package com.guo.offer.outofmemory;

import java.util.*;

public class OOMTest1 {
	public static void main(String... args) {
		List<byte[]> buffer = new ArrayList<byte[]>();
		buffer.add(new byte[10 * 1024 * 1024]);
	}
}