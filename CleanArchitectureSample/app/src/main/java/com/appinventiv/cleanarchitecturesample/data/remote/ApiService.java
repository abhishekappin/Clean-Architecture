package com.appinventiv.cleanarchitecturesample.data.remote;



import com.appinventiv.cleanarchitecturesample.data.model.User;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {

    @GET("users")
    Single<List<User>> getUserList();
}
