package com.fitnessapp;

import android.app.Application;
import android.content.Context;

import com.buddy.sdk.Buddy;

/**
 * Created by hitesh on 3/3/17.
 */

public class FitnessApp extends Application {

    String appId = "574183e2-978c-4cac-b8f7-0888d6d978bd";
    String appKey = "O5gQiobypGcVHL1JRlOyh2qiJgOP1Abo";

    @Override
    public void onCreate() {
        super.onCreate();
        Context myContext = getApplicationContext();
        Buddy.init(myContext, appId, appKey);
    }
}
