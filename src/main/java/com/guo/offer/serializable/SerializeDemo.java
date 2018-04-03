package com.guo.offer.serializable;

import java.io.*;

public class SerializeDemo {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.setName("wwq");
        e.setAddress("qqq");
        e.setSSN(221);
        e.setNumber(3434);
        try {
            File file = new File("E:/tmp/employee.ser");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}