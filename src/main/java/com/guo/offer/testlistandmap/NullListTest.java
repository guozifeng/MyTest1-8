package com.guo.offer.testlistandmap;

import java.util.List;

/**
 * java中判断list是否为空的用法 1、如果想判断list是否为空，可以这么判断：
 * 
 * if(null == list || list.size() ==0 ){
 * 
 * //为空的情况
 * 
 * }else{
 * 
 * //不为空的情况
 * 
 * }
 * 
 * 2、list.isEmpty() 和 list.size()==0 有啥区别呢
 * 
 * 答案：没有区别 。isEmpty()判断有没有元素，而size()返回有几个元素， 如果判断一个集合有无元素
 * 建议用isEmpty()方法.比较符合逻辑用法。
 * 
 * 3、list！=null 跟 ！ list.isEmpty()有什么区别? 这就相当与，你要要到商店买东西 list！=null 首先判断是否有商店
 * ！list.isEmpty() 没有判断商店是否存在，而是判断商店是否有东西 总结用法：如果连商店都没有，何来的的东西可卖 所以一般的判断是
 * if(list!=null && !list.isEmpty()){ //不为空的情况 }else{ //为空的情况 }
 * 
 * @author Administrator
 *
 */
public class NullListTest {
    public static void main(String[] args) {
        List list = null;
        
        //list==null 时  list.size() 和  list.isEmpty() 均抛出异常
        
        if(list != null && list.size() == 0){
            System.out.println("1");
        }else{
            System.out.println("2");
        }
        
        
        String b = null;
        String a = "aa";
        
        System.out.println(a.equals(b));
        //抛出异常
        System.out.println(b.equals(a));
    }
}
