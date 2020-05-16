package com.example.api.util;

import java.util.UUID;

/**
 * @author yzx
 * @date 2020/5/16  17:41
 */
public class UUIDUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
