package com.guo.offer.testlistandmap;

import java.util.List;

/**
 * java���ж�list�Ƿ�Ϊ�յ��÷� 1��������ж�list�Ƿ�Ϊ�գ�������ô�жϣ�
 * 
 * if(null == list || list.size() ==0 ){
 * 
 * //Ϊ�յ����
 * 
 * }else{
 * 
 * //��Ϊ�յ����
 * 
 * }
 * 
 * 2��list.isEmpty() �� list.size()==0 ��ɶ������
 * 
 * �𰸣�û������ ��isEmpty()�ж���û��Ԫ�أ���size()�����м���Ԫ�أ� ����ж�һ����������Ԫ��
 * ������isEmpty()����.�ȽϷ����߼��÷���
 * 
 * 3��list��=null �� �� list.isEmpty()��ʲô����? ����൱�룬��ҪҪ���̵����� list��=null �����ж��Ƿ����̵�
 * ��list.isEmpty() û���ж��̵��Ƿ���ڣ������ж��̵��Ƿ��ж��� �ܽ��÷���������̵궼û�У������ĵĶ������� ����һ����ж���
 * if(list!=null && !list.isEmpty()){ //��Ϊ�յ���� }else{ //Ϊ�յ���� }
 * 
 * @author Administrator
 *
 */
public class NullListTest {
    public static void main(String[] args) {
        List list = null;
        
        //list==null ʱ  list.size() ��  list.isEmpty() ���׳��쳣
        
        if(list != null && list.size() == 0){
            System.out.println("1");
        }else{
            System.out.println("2");
        }
        
        
        String b = null;
        String a = "aa";
        
        System.out.println(a.equals(b));
        //�׳��쳣
        System.out.println(b.equals(a));
    }
}
