package com.hoon2c.callelevatorsds.service;

public class AptApiServiceHolder {
    private static AptApiService instance = null;
    public static AptApiService getInstance() {
        if (null == instance) {
            instance = new AptApiService();
        }
        return instance;
    }
}
