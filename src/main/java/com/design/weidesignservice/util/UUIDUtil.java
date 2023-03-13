package com.design.weidesignservice.util;

import java.util.UUID;

public class UUIDUtil {

    public static String getUUID(){
        String id = UUID.randomUUID().toString();

        return id.replaceAll("-", "");
    }

    //测试
    public static void main(String[] args) {

        String uid = UUIDUtil.getUUID();
        System.out.println("===="+uid);
    }
}
