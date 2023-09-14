package com.appinventiv.cleanarchitecturesample.data.remote;

import static com.appinventiv.cleanarchitecturesample.core.utils.Constant.BASE_URL;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static RetrofitInstance instance = null;
    private RetrofitInstance() {
    }

    public static RetrofitInstance getRetrofitInstance(){
        if (instance == null){
            instance =  new RetrofitInstance();
        }
        return instance;
    }

    private Retrofit getRetrofit(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        return  new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public ApiService getAPIService(){
        return getRetrofit().create(ApiService.class);
    }
}
