package com.appinventiv.cleanarchitecturesample.domain.repository;

import com.appinventiv.cleanarchitecturesample.data.model.User;

import java.util.List;

import io.reactivex.Single;

public interface UserRepository {
    Single<List<User>> getUserList();
}
