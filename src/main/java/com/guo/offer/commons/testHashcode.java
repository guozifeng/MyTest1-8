package com.guo.offer.commons;

public class testHashcode {

    private String name;

    @Override
    public int hashCode() {
        System.out.println("hashCode");
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("equals");
        return super.equals(obj);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "testHashcode [name=" + name + "]";
    }

    public static void main(String[] args) {

        final testHashcode o = new testHashcode();
        o.setName("1111");
        System.out.println(o);

        testHashcode o1 = o;
        o1.setName("2222");

        System.out.println(o);
        System.out.println(o1);
    }

}
