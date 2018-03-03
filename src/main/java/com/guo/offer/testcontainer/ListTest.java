package com.guo.offer.testcontainer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class ListTest {

    @Test
    public void test1() {

        List list = new ArrayList();
        list.add("2232");
        list.add(232);
        list.add(new Date());
        System.out.println(list.get(0));

        List list1 = new ArrayList();
        list1.add("2232");
        list1.add(232);
        list1.add(new Date());
        System.out.println(list1.get(0));

        list.addAll(list);
        System.out.println(list);
    }
}
