package com.akexorcist.keepdatatesting;

/**
 * Created by Akexorcist on 1/20/2017 AD.
 */

public class SingletonCurrentUser {
    private static SingletonCurrentUser singletonCurrentUser;

    public static SingletonCurrentUser getInstance() {
        if (singletonCurrentUser == null) {
            singletonCurrentUser = new SingletonCurrentUser();
        }
        return singletonCurrentUser;
    }

    private String name;

    public SingletonCurrentUser() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
