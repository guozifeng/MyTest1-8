package com.guo.offer.datastructure;

import java.util.Stack;

/**
 * @author JInShuangQi
 *
 * 2015年7月27日
 */
public class E07QueueWithTwoStacks {
    /**
     * 用两个栈实现一个队列，完成两个函数appendTail和deletedHead,分别是在队列尾部插入节点
     * 和在队列头部删除节点的功能 
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
            throw new Exception("队列为空，不能删除");
        }
        return stack2.pop();
    }
    
    public static void main(String[] args) throws Exception{
        E07QueueWithTwoStacks test  = new E07QueueWithTwoStacks();
        test.appendTail("1");
        test.appendTail("2");
        test.appendTail("3");
        System.out.println(test.deletedHead());
    }
}