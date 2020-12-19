package com.itheima.ssm.utils;

import java.util.UUID;

public final class UuidUtil {
    private UuidUtil(){}
    public static String getUuid(){
        return UUID.randomUUID().toString().replace("-","");

    }

    public static void main(String[] args) {
        System.out.println(UuidUtil.getUuid());
    }
}
