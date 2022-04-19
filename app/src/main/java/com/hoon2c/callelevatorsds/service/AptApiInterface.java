package com.hoon2c.callelevatorsds.service;

import com.hoon2c.callelevatorsds.model.ResponseCall;
import com.hoon2c.callelevatorsds.model.ResponseState;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AptApiInterface {
    String baseURL = "http://10.2.1.12";

    @GET("/seoulapp/ezon_v2/common/elevator.do?method=ezon_v2.common.elevator.StateXML&hogi1=20")
    Call<ResponseState> getState();

    @GET("/seoulapp/ezon_v2/common/elevator.do?method=ezon_v2.common.elevator.CallXML&flag=down&hogi=20")
    Call<ResponseCall> getCall();
}
