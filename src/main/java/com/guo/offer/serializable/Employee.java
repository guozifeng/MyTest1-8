package com.guo.offer.serializable;

public class Employee implements java.io.Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 3746087476091270542L;
    public String name;
    public String address;
    public transient int SSN;
    public int number;

    public void mailCheck() {
        System.out.println("Mailing a check to " + name + " " + address);
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", address=" + address + ", SSN=" + SSN + ", number=" + number + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSSN() {
        return SSN;
    }

    public void setSSN(int sSN) {
        SSN = sSN;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
}