package com.hoon2c.callelevatorsds.service;

import com.hoon2c.callelevatorsds.factory.RetrofitFactory;
import com.hoon2c.callelevatorsds.model.ResponseCall;
import com.hoon2c.callelevatorsds.model.ResponseState;

import retrofit2.Call;

public class AptApiService {

    public static AptApiService getInstance() {
        return AptApiServiceHolder.getInstance();
    }

    public Call<ResponseState> getState() {
        return RetrofitFactory.createRetrofit()
                .create(AptApiInterface.class).getState();
    }

    public Call<ResponseCall> getCall() {
        return RetrofitFactory.createRetrofit()
                .create(AptApiInterface.class).getCall();
    }
}
