package com.guo.offer.testkeyword;

/**
 * @author Administrator
 * @date 2018/02/22
 */
public enum Color {

    /**
     * ��ɫ
     */
    RED(1),

    /**
     * ��ɫ
     */
    BANK(2),

    /**
     * ��ɫ
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