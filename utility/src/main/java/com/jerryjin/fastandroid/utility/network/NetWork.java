package com.jerryjin.fastandroid.utility.network;

import com.jerryjin.fastandroid.utility.handler.Execution;

import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;

public abstract class NetWork {

//    private static NetWork instance;
//    private Retrofit retrofit;
//
//    static {
//        instance = new NetWork();
//    }
//
//    private NetWork() {
//
//    }
//
//    public static NetWork getInstance(){
//        return instance;
//    }


    protected abstract OkHttpClient getOkHttpClient();

    protected Retrofit getRetrofit(String baseUrl, Converter.Factory factory){
        OkHttpClient client = getOkHttpClient();
        Retrofit.Builder builder = new Retrofit.Builder();
        return builder
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(factory)
                .build();
    }


}
