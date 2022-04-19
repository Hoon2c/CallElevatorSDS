package com.hoon2c.callelevatorsds.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="root", strict = false)
public class ResponseCall {
    @Element(name="elevatorCallFlag")
    private boolean elevatorCallFlag;

    public boolean isElevatorCallFlag() {
        return elevatorCallFlag;
    }

    public void setElevatorCallFlag(boolean elevatorCallFlag) {
        this.elevatorCallFlag = elevatorCallFlag;
    }
}
