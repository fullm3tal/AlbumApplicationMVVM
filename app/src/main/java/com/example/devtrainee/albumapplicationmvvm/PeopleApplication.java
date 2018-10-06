package com.example.devtrainee.albumapplicationmvvm;

import android.app.Application;

import com.example.devtrainee.albumapplicationmvvm.dagger.component.ApplicationComponent;
import com.example.devtrainee.albumapplicationmvvm.dagger.component.DaggerApplicationComponent;


public class PeopleApplication extends Application {

    private static final String TAG = "PeopleApplication";
    private static ApplicationComponent component;


    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
               .build();
    }

    public static ApplicationComponent getComponent(){
        return component;
    }
}
