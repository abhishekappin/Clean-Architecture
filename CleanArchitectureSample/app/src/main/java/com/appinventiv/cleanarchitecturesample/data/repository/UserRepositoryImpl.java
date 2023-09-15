package com.appinventiv.cleanarchitecturesample.data.repository;

import com.appinventiv.cleanarchitecturesample.data.model.User;
import com.appinventiv.cleanarchitecturesample.data.remote.RetrofitInstance;
import com.appinventiv.cleanarchitecturesample.domain.repository.UserRepository;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public Single<List<User>> getUserList(){
        return RetrofitInstance.getRetrofitInstance()
                .getAPIService()
                .getUserList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
