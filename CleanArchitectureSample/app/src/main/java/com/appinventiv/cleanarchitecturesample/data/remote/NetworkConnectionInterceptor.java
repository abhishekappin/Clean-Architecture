package com.appinventiv.cleanarchitecturesample.data.remote;

import androidx.annotation.NonNull;

import com.appinventiv.cleanarchitecturesample.core.utils.NetworkUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * This NetworkConnectionInterceptor is used to throw a custom exception,
 * here in this case, it checks the Network Availability and throws exception
 * whenever there is No Internet Availability
 */
public class NetworkConnectionInterceptor implements Interceptor {

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        if(!NetworkUtils.isNetworkAvailable())
            throw new IOException("No Internet Connection Available");

        Request.Builder builder = chain.request().newBuilder();

        return chain.proceed(builder.build());
    }
}
