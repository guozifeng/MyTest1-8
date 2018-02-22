package com.guo.offer.testkeyword;

/**
 * @author Administrator
 * @date 2018/02/22
 */
public enum Color {

    /**
     * ºìÉ«
     */
    RED(1),

    /**
     * ºÚÉ«
     */
    BANK(2),

    /**
     * °×É«
     */
    WHITH(3);

    private int value;

    private Color(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}