package com.guo.offer.testserializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestSerialversionUID {

    public static void main(String[] args) throws Exception {
        // SerializeCustomer();// ���л�Customer����
        Customer customer = DeserializeCustomer();// ������Customer����
        System.out.println(customer);
    }

    /**
     * MethodName: SerializeCustomer Description: ���л�Customer����
     * 
     * @author xudp
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static void SerializeCustomer() throws FileNotFoundException, IOException {
        Customer customer = new Customer("gacl", 25);
        // ObjectOutputStream ���������
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("E:/Customer.txt")));
        oo.writeObject(customer);
        System.out.println("Customer�������л��ɹ���");
        oo.close();
    }

    /**
     * MethodName: DeserializeCustomer Description: ������Customer����
     * 
     * @author xudp
     * @return
     * @throws Exception
     * @throws IOException
     */
    private static Customer DeserializeCustomer() throws Exception, IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("E:/Customer.txt")));
        Customer customer = (Customer)ois.readObject();
        System.out.println("Customer�������л��ɹ���");
        return customer;
    }
}

/**
 * <p>
 * ClassName: Customer
 * <p>
 * <p>
 * Description: Customerʵ����Serializable�ӿڣ����Ա����л�
 * <p>
 * 
 * @author xudp
 * @version 1.0 V
 * @createTime 2014-6-9 ����04:20:17
 */
class Customer implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    // Customer����û�ж���serialVersionUID
    private String name;
    private int age;

    // �����ӵ�sex����
    /*private String sex;
    public String getSex() {
    	return sex;
    }
    
    public void setSex(String sex) {
    	this.sex = sex;
    }*/

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /*
     * @MethodName toString
     * @Description ��дObject���toString()����
     * @author xudp
     * @return string
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "name=" + name + ", age=" + age;
    }
}