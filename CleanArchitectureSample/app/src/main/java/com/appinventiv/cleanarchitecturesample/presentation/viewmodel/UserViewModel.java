package com.appinventiv.cleanarchitecturesample.presentation.viewmodel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.appinventiv.cleanarchitecturesample.data.model.User;
import com.appinventiv.cleanarchitecturesample.data.remote.Resource;
import com.appinventiv.cleanarchitecturesample.data.repository.UserRepositoryImpl;
import com.appinventiv.cleanarchitecturesample.domain.use_case.GetUserUseCase;

import org.reactivestreams.Publisher;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * This viewmodel holds the User related data for Home Activity.
 */
public class UserViewModel extends ViewModel {

    public MutableLiveData<Resource<List<User>>> usersListLiveData = new MediatorLiveData<>();
    private final GetUserUseCase userUseCase;
    public UserViewModel() {
        userUseCase = new GetUserUseCase(new UserRepositoryImpl());
        getUserData();
    }

    /**
     * This method handles the different callback methods of RxJava
     * and update the Livedata accordingly.
     */
    private void getUserData(){
      usersListLiveData.postValue(Resource.loading(null));
        userUseCase.getUserList()
                .subscribe(new SingleObserver<List<User>>() {
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
