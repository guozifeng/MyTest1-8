package com.guo.jvm.ten;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("hello", "ฤใบร");
        map.put("how are you?", "ณิมหรปฃฟ");
        System.out.println(map.get("hello"));
        System.out.println(map.get("how are you?"));
    }
}
