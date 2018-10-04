package com.example.devtrainee.albumapplicationmvvm;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.devtrainee.albumapplicationmvvm.pojo.People;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class PeopleViewModel extends ViewModel {

    MutableLiveData<PeopleResponse> responseLiveData;

    public LiveData<PeopleResponse> getPeopleList() {
        if (responseLiveData == null) {
            responseLiveData = new MutableLiveData<>();
        }
        return responseLiveData;
    }

    public void loadPeopleList() {
        PeopleFactory.getPeopleClient().getPeopleList(PeopleFactory.RANDOM_USER_URL)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        responseLiveData.setValue(PeopleResponse.loading());
                    }
                })
        .subscribe(new Observer<PeopleResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(PeopleResponse peopleResponse) {
                responseLiveData.setValue(PeopleResponse.success(peopleResponse.peopleList));
            }

            @Override
            public void onError(Throwable e) {
                responseLiveData.setValue(PeopleResponse.failure(e));
            }

            @Override
            public void onComplete() {

            }
        });

    }
}