package com.example.devtrainee.albumapplicationmvvm;

import com.example.devtrainee.albumapplicationmvvm.pojo.People;

import java.util.List;

public class ResPeople {

    public Status status;

    public List<People> peopleList;

    public Throwable error;

    public ResPeople(Status status, List<People> peopleList, Throwable error) {
        this.status = status;
        this.peopleList = peopleList;
        this.error = error;
    }

    public static ResPeople loading() {
        return new ResPeople(Status.LOADING, null, null);
    }

    public static ResPeople success(List<People> peopleList) {
        return new ResPeople(Status.SUCCESS, peopleList, null);
    }

    public static ResPeople failure(Throwable error) {
        return new ResPeople(Status.FAILURE, null, error);
    }


}
