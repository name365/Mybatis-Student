package com.github.subei.utils;

import org.junit.Test;

import java.util.UUID;

@SuppressWarnings("all") //抑制警告
public class IDutils {
    public static String getID(){
        return UUID.randomUUID().toString().replaceAll(".","-");
    }

    @Test
    public void test(){
        System.out.println(IDutils.getID());
    }

}
