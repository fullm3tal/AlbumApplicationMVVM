package com.example.devtrainee.albumapplicationmvvm;

import com.example.devtrainee.albumapplicationmvvm.pojo.People;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PeopleResponse {

    @SerializedName("results")
    List<People> peopleList;

    public List<People> getList() {
        return peopleList;
    }

}
