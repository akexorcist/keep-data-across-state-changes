package com.akexorcist.keepdatatesting;

/**
 * Created by Akexorcist on 1/20/2017 AD.
 */

public class StaticCurrentUser {
    private static String name;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        StaticCurrentUser.name = name;
    }
}
