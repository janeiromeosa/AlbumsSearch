package com.example.jsonprojecttrial;

import android.app.Application;

import com.example.jsonprojecttrial.di.app.AppComponent;
import com.example.jsonprojecttrial.di.app.DaggerAppComponent;

public class MyApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
