package com.example.devtrainee.albumapplicationmvvm;


import retrofit2.http.GET;
import retrofit2.http.Url;

public interface PeopleService {
    @GET
    io.reactivex.Observable<PeopleResponse> getPeopleList(@Url String url);
}
