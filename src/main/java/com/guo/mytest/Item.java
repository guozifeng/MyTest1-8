package com.guo.mytest;

import java.math.BigDecimal;

public class Item {
    private String name;

    private Integer qty;

    private BigDecimal price;

    public Item() {
        this.name = "";
        this.price = new BigDecimal("0");
        this.qty = 0;

        // System.out.println("-------------");
    }

    public Item(String name, Integer qty, BigDecimal price) {

        this.name = name;
        this.price = price;
        this.qty = qty;

    }

    public String getName() {
        return name;
    }

    public Integer getQty() {
        return qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((qty == null) ? 0 : qty.hashCode());
        return (int)System.currentTimeMillis();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item [name=" + name + ", qty=" + qty + ", price=" + price + "]";
    }

}
