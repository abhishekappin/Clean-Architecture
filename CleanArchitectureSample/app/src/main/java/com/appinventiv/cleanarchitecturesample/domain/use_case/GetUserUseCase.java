package com.appinventiv.cleanarchitecturesample.domain.use_case;


import com.appinventiv.cleanarchitecturesample.data.model.User;
import com.appinventiv.cleanarchitecturesample.data.repository.UserRepositoryImpl;

import java.util.List;

import io.reactivex.Single;

public class GetUserUseCase {

    private UserRepositoryImpl userRepositoryImpl;
    public GetUserUseCase(UserRepositoryImpl userRepositoryImpl) {
        this.userRepositoryImpl = userRepositoryImpl;
    }

    public Single<List<User>> getUserList(){
        return userRepositoryImpl.getUserList();
    }
}
