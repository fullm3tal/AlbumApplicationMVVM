package com.example.devtrainee.albumapplicationmvvm;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class PeopleViewModel extends ViewModel {

    MutableLiveData<ResPeople> responseLiveData;

    public LiveData<ResPeople> getPeopleList() {
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
                        responseLiveData.setValue(ResPeople.loading());
                    }
                })
                .subscribe(new Observer<PeopleResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PeopleResponse peopleResponse) {
                        responseLiveData.setValue(ResPeople.success(peopleResponse.peopleList));
                    }

                    @Override
                    public void onError(Throwable e) {
                        responseLiveData.setValue(ResPeople.failure(e));
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}