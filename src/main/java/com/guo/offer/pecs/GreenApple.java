package com.guo.offer.pecs;

public class GreenApple extends Apple {
    private Integer b = 1;

    @Override
    public String toString() {
        return "GreenApple [b=" + b + "]";
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

}
