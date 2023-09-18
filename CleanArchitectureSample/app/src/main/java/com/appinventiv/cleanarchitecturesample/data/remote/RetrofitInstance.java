package com.appinventiv.cleanarchitecturesample.data.remote;

import static com.appinventiv.cleanarchitecturesample.core.utils.Constant.BASE_URL;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This class is used to provide the reference of Retrofit and ApiService class
 */
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

    /**
     * This method returns the instance of Retrofit Builder
     * @return Retrofit
     */
    private Retrofit getRetrofit(){
        return  new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .client(getHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * This method adds interceptor to the Retrofit API request and modify the response
     * Here it adds the logging and Network Error handling feature to the API
     * @return OkHttpClient
     */
    private OkHttpClient getHttpClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new NetworkConnectionInterceptor())
                .addInterceptor(interceptor).build();
        return client;
    }

    /**
     * This method returns the reference of ApiService Interface
     * @return ApiService
     */
    public ApiService getAPIService(){
        return getRetrofit().create(ApiService.class);
    }
}
