package com.example.devtrainee.albumapplicationmvvm.dagger.module;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.example.devtrainee.albumapplicationmvvm.PeopleActivity;
import com.example.devtrainee.albumapplicationmvvm.PeopleViewModel;
import com.example.devtrainee.albumapplicationmvvm.PeopleViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module()
public class PeopleActivityModule {

    @Provides
    PeopleViewModel getPeopleViewModel(Context context){
        return ViewModelProviders.of((PeopleActivity) context,new PeopleViewModelFactory()).get(PeopleViewModel.class);
    }

}
