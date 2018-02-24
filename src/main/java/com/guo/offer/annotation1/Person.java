package com.guo.offer.annotation1;
public class Person extends BasePerson {
    
    @Encrypt
    public String name;
    
    public String phone;

    @Override
    public String toString() {
        return "Person [name=" + name + ", phone=" + phone + "]";
    }
    
}
