package com.hoon2c.callelevatorsds.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="item", strict = false)
public class ResponseItem {
    @Element(name="doorState")
    private String doorState;
    @Element(name="dong")
    private String dong;
    @Element(name="state")
    private String state;
    @Element(name="floor")
    private String floor;
    @Element(name="way")
    private String way;
    @Element(name="status")
    private String status;

    public String getDoorState() {
        return doorState;
    }

    public void setDoorState(String doorState) {
        this.doorState = doorState;
    }

    public String getDong() {
        return dong;
    }

    public void setDong(String dong) {
        this.dong = dong;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
