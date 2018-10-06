package com.example.devtrainee.albumapplicationmvvm.dagger.module;

import com.example.devtrainee.albumapplicationmvvm.PeopleService;
import com.example.devtrainee.albumapplicationmvvm.dagger.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class PeopleServiceModule {

    private final static String BASE_URL = "http://api.randomuser.me/";
    public final static String RANDOM_USER_URL = "http://api.randomuser.me/?results=10&nat=en";
    public final static String PROJECT_URL = "https://github.com/erikcaffrey/People-MVVM";

    @Provides
    @ApplicationScope
    PeopleService peopleService(Retrofit retrofitFactory) {
        return retrofitFactory.create(PeopleService.class);
    }

    @Provides
    @ApplicationScope
    Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

}
