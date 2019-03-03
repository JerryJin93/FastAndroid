package com.jerryjin.fastandroid.utility.network;

import android.support.annotation.NonNull;

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


    @NonNull
    protected abstract OkHttpClient getOkHttpClient();

    @NonNull
    protected Retrofit getRetrofit(@NonNull String baseUrl, @NonNull Converter.Factory factory){
        OkHttpClient client = getOkHttpClient();
        Retrofit.Builder builder = new Retrofit.Builder();
        return builder
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(factory)
                .build();
    }


}
