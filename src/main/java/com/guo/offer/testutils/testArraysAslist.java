package com.guo.offer.testutils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class testArraysAslist {

    public static void main(String[] args) {

        String[] str = new String[] {"you", "wu"};
        List list = Arrays.asList(str);
        list.add("yangguanbao");
        str[1] = "gujin";
        System.out.println(str[0] + " " + str[1]);
        System.out.println(list.get(0) + " " + list.get(1));
    }

}
