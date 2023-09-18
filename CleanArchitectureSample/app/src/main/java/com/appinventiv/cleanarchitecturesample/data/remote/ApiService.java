package com.appinventiv.cleanarchitecturesample.data.remote;



import com.appinventiv.cleanarchitecturesample.data.model.User;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * This interface is to declare the methods which will
 */
public interface ApiService {

    /**
     * This GET API is used to fetch the user list.
     * Single is used to get the User List once, whenever requested
     */
    @GET("users")
    Single<List<User>> getUserList();

}
