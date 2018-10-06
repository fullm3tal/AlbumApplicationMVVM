package com.example.devtrainee.albumapplicationmvvm.dagger.component;

import com.example.devtrainee.albumapplicationmvvm.PeopleService;
import com.example.devtrainee.albumapplicationmvvm.dagger.module.PeopleServiceModule;
import com.example.devtrainee.albumapplicationmvvm.dagger.scope.ApplicationScope;

import dagger.Component;

@ApplicationScope
@Component(modules = {PeopleServiceModule.class})
public interface ApplicationComponent {
    PeopleService getPeopleService();
}
