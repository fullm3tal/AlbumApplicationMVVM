package com.example.devtrainee.albumapplicationmvvm;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeopleFactory {

    private PeopleFactory() {

    }

    private final static String BASE_URL = "http://api.randomuser.me/";
    public final static String RANDOM_USER_URL = "http://api.randomuser.me/?results=10&nat=en";
    public final static String PROJECT_URL = "https://github.com/erikcaffrey/People-MVVM";

    public static PeopleService getPeopleClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(PeopleService.class);

    }

}
