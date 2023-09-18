package com.appinventiv.cleanarchitecturesample;

import android.app.Application;
import android.content.Context;


public class CleanArchitectureApp extends Application {

    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    /**
     * This method provides the Context reference
     * @return Context
     */
    public static Context getAppContext(){
        return mContext;
    }

}
