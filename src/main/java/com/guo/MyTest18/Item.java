package com.guo.MyTest18;

import java.math.BigDecimal;

public class Item {
	private String name;

	private Integer qty;

	private BigDecimal price;

	public Item(String name, Integer qty, BigDecimal price) {

		this.name = name;
		this.price = price;
		this.qty = qty;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", qty=" + qty + ", price=" + price + "]";
	}

}
