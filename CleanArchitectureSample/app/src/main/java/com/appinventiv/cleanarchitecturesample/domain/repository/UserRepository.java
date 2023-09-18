package com.appinventiv.cleanarchitecturesample.domain.repository;

import com.appinventiv.cleanarchitecturesample.data.model.User;

import java.util.List;

import io.reactivex.Single;

/**
 * This interface declares all the abstract methods, which fetch the user related data
 */
public interface UserRepository {
    Single<List<User>> getUserList();
}
