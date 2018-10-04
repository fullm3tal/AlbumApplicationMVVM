package com.example.devtrainee.albumapplicationmvvm;

import com.example.devtrainee.albumapplicationmvvm.pojo.People;

import java.util.List;

public class PeopleResponse {


    public Status status;

    public List<People> peopleList;

    public Throwable error;

    public PeopleResponse(Status status, List<People> peopleList, Throwable error) {
        this.status = status;
        this.peopleList = peopleList;
        this.error = error;
    }

    public static PeopleResponse loading() {
        return new PeopleResponse(Status.LOADING, null, null);
    }

    public static PeopleResponse success(List<People> peopleList) {
        return new PeopleResponse(Status.SUCCESS, peopleList, null);
    }

    public static PeopleResponse failure(Throwable error) {
        return new PeopleResponse(Status.FAILURE, null, error);
    }

}
