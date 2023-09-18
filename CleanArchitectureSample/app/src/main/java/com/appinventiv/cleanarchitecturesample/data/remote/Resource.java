package com.appinventiv.cleanarchitecturesample.data.remote;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * This is a Google defined generic format to handle the different stages of API Response.
 * @param <T>
 */
public class Resource<T> {

    @NonNull public final Status status;
    @Nullable public final T data;
    @Nullable public final String message;

    public Resource(@NonNull Status status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> Resource<T> success (@NonNull T data){
        return new Resource<>(Status.SUCCESS, data, null);
    }
    public static <T> Resource<T> error (String msg, @NonNull T data){
        return new Resource<>(Status.ERROR, data, msg);
    }
    public static <T> Resource<T> loading (@NonNull T data){
        return new Resource<>(Status.LOADING, data, null);
    }

    /**
     * Enum constants to represent the API response state i.e. SUCCESS, ERROR, LOADING
     */
    public enum Status { SUCCESS, ERROR, LOADING }
}
