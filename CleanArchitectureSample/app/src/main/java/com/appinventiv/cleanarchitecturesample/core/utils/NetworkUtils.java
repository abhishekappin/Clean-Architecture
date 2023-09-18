package com.appinventiv.cleanarchitecturesample.core.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.appinventiv.cleanarchitecturesample.CleanArchitectureApp;

public class NetworkUtils {

    /**
     * This method is used to fetch the internet availability
     * @return boolean
     */
    public static boolean isNetworkAvailable(){
        Context context = CleanArchitectureApp.getAppContext();
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }
}
