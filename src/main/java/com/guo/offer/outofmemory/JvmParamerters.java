package com.guo.offer.outofmemory;

import java.lang.management.ManagementFactory;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class JvmParamerters {
    public static void main(String[] args){
        List<String> paramters = ManagementFactory.getRuntimeMXBean().getInputArguments();
        System.out.println(StringUtils.join(paramters,":"));
    }
}