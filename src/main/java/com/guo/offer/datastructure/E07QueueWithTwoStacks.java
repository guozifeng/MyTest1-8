package com.guo.offer.datastructure;

import java.util.Stack;

/**
 * @author JInShuangQi
 *
 * 2015��7��27��
 */
public class E07QueueWithTwoStacks {
    /**
     * ������ջʵ��һ�����У������������appendTail��deletedHead,�ֱ����ڶ���β������ڵ�
     * ���ڶ���ͷ��ɾ���ڵ�Ĺ��� 
     */
    private Stack<String> stack1 = new Stack<String>();
    private Stack<String> stack2 = new Stack<String>();
    
    public void appendTail(String s){
        stack1.push(s);
    }
    public String deletedHead() throws Exception{
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            throw new Exception("����Ϊ�գ�����ɾ��");
        }
        return stack2.pop();
    }
    
    public static void main(String[] args) throws Exception{
        E07QueueWithTwoStacks test  = new E07QueueWithTwoStacks();
        test.appendTail("1");
        test.appendTail("2");
        test.deletedHead();
    }
}