package com.example.devtrainee.albumapplicationmvvm;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public class PeopleViewModelFactory implements ViewModelProvider.Factory {
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(PeopleViewModel.class)){
            return (T) new PeopleViewModel();
        }
        throw new IllegalArgumentException("Unknown ViewModel Class");
    }
}
