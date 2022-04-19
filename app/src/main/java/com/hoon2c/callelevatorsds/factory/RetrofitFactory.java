package com.hoon2c.callelevatorsds.factory;

import com.hoon2c.callelevatorsds.service.AptApiInterface;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class RetrofitFactory {
    public static Retrofit createRetrofit() {
        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl(AptApiInterface.baseURL)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        return retrofit;
    }
}
