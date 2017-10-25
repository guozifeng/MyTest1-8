/**
 * 
 */
package com.guo.offer.testlistandmap;

import java.util.HashMap;

/**
 * @author Administrator
 *
 */
public class testHashMap {
	private int id;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = 11;
		System.out.println(result);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		/*
		 * if (this == obj) return true; if (obj == null) return false; if
		 * (getClass() != obj.getClass()) return false; testHashMap other =
		 * (testHashMap) obj; if (id != other.id) return false;
		 */
		System.out.println("99");
		return true;
	}

	/**
	 * 
	 */
	public testHashMap() {
		// TODO Auto-generated constructor stub
	}

	static final int MAXIMUM_CAPACITY = 1 << 30;

	private static int roundUpToPowerOf2(int number) {
		// assert number >= 0 : "number must be non-negative";
		return number >= MAXIMUM_CAPACITY ? MAXIMUM_CAPACITY
				: (number > 1) ? Integer.highestOneBit((number - 1) << 1) : 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		testHashMap a1 = new testHashMap();
		a1.setId(1);
		testHashMap a2 = new testHashMap();
		a2.setId(2);
		testHashMap a3 = new testHashMap();

		HashMap map = new HashMap();
		System.out.println(map.put(a1, "a"));
		System.out.println("---------1--------");
		System.out.println(map.put(a2, "b"));
		System.out.println("----------2-------");
		System.out.println(map.size());
		System.out.println("-----------3------");
		System.out.println(map);
		System.out.println("-----------4------");
		System.out.println(map.get(a3));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
