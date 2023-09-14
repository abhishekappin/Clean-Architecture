package com.appinventiv.cleanarchitecturesample.presentation.viewmodel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.appinventiv.cleanarchitecturesample.data.model.User;
import com.appinventiv.cleanarchitecturesample.data.remote.Resource;
import com.appinventiv.cleanarchitecturesample.data.repository.UserRepositoryImpl;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class UserViewModel extends ViewModel {

    public MutableLiveData<Resource<List<User>>> usersListLiveData = new MediatorLiveData<>();
    private final UserRepositoryImpl userRepositoryImpl;
    private MediatorLiveData<Resource<List<User>>> authUser = new MediatorLiveData<>();
    public UserViewModel() {
        userRepositoryImpl = new UserRepositoryImpl();
        getUserData();
    }

    private void getUserData(){
      usersListLiveData.postValue(Resource.loading(null));
        userRepositoryImpl.getUserList().subscribe(new SingleObserver<List<User>>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onSuccess(List<User> users) {
                usersListLiveData.postValue(Resource.success(users));
            }

            @Override
            public void onError(Throwable e) {
                usersListLiveData.postValue(Resource.error(e.getMessage(),null));
            }
        });
    }
}
