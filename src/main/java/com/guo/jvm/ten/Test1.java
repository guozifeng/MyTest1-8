package com.guo.jvm.ten;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("hello", "ฤใบร");
        map.put("how are you?", "ณิมหรปฃฟ");
        System.out.println((String)map.get("hello"));
        System.out.println((String)map.get("how are you?"));
    }

}
