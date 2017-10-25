package com.guo.offer.pecs;

public class GreenApple extends Apple {
	private int b = 1;

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return "GreenApple [b=" + b + "]";
	}
}
