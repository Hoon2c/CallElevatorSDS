package com.hoon2c.callelevatorsds.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="root", strict = false)
public class ResponseState {

    @Element(name="item")
    private ResponseItem item;

    @Element(name="connection")
    private String connection;

    public ResponseItem getItem() {
        return item;
    }

    public void setItem(ResponseItem item) {
        this.item = item;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }
}
