package com.wish.common.util;

import java.util.UUID;

public class IdUtil {

    public static String getID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
