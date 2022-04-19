package com.hoon2c.callelevatorsds;

import android.content.Context;
import android.os.Handler;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import com.hoon2c.callelevatorsds.model.ElevatorCallResult;
import com.hoon2c.callelevatorsds.model.ElevatorState;
import com.hoon2c.callelevatorsds.model.ResponseCall;
import com.hoon2c.callelevatorsds.model.ResponseState;
import com.hoon2c.callelevatorsds.service.AptApiInterface;
import com.hoon2c.callelevatorsds.service.AptApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class WebAppInterface {

    Context mContext;
    Handler mHandler = null;
    WebView mWebView;

    WebAppInterface(Context c, WebView w) {
        mContext = c;
        mWebView = w;
        mHandler = new Handler();
    }

    /*
    <script type="text/javascript">
        Android.getElevatorState();
    </script>
    */
    @JavascriptInterface
    public void getElevatorState() {
        ElevatorState elevatorState = new ElevatorState();

        AptApiService.getInstance().getState().enqueue(new Callback<ResponseState>() {
            @Override
            public void onResponse(Call<ResponseState> call, Response<ResponseState> response) {
                ResponseState responseState = response.body();
                elevatorState.setFloor(responseState.getItem().getFloor());
                elevatorState.setWay(responseState.getItem().getWay());
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            mWebView.loadUrl("javascript:callBack_getState('" + elevatorState.getFloor()  +"', '" + elevatorState.getWay() + "');");
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });
            }
            @Override
            public void onFailure(Call<ResponseState> call, Throwable t) {}
        });
    }

    /*
    <script type="text/javascript">
        Android.getCall();
    </script>
    */
    @JavascriptInterface
    public void getCall() {
        ElevatorCallResult result = new ElevatorCallResult();

        AptApiService.getInstance().getCall().enqueue(new Callback<ResponseCall>() {
            @Override
            public void onResponse(Call<ResponseCall> call, Response<ResponseCall> response) {
                 ResponseCall responseCall = response.body();
                result.setSuccess(responseCall.isElevatorCallFlag());
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            mWebView.loadUrl("javascript:callBack_getCall(" + result.isSuccess() + ");");
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });
            }
            @Override
            public void onFailure(Call<ResponseCall> call, Throwable t) {}
        });
    }
}
