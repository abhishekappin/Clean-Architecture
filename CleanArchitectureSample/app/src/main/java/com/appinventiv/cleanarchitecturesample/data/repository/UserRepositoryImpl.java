package com.appinventiv.cleanarchitecturesample.data.repository;

import com.appinventiv.cleanarchitecturesample.data.model.User;
import com.appinventiv.cleanarchitecturesample.data.remote.RetrofitInstance;
import com.appinventiv.cleanarchitecturesample.domain.repository.UserRepository;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * This class is an implementation of UserRepository interface defined in domain layer
 */
public class UserRepositoryImpl implements UserRepository {

    /**
     * This override method is an implementation to provide List of users in a Single RxJava observable
     * through Retrofit Network library
     * @return List<User>
     */
    @Override
    public Single<List<User>> getUserList(){
        return RetrofitInstance.getRetrofitInstance()
                .getAPIService()
                .getUserList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
