package com.example.devtrainee.albumapplicationmvvm.dagger.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    public final Context context;

    public ContextModule(Context context){
    this.context=context;
    }

    @Provides
    public Context context(){
        return context;
    }

}
