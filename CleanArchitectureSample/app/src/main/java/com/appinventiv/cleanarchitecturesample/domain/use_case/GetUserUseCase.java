package com.appinventiv.cleanarchitecturesample.domain.use_case;


import com.appinventiv.cleanarchitecturesample.data.model.User;
import com.appinventiv.cleanarchitecturesample.data.repository.UserRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.functions.Function;

/**
 * This GetUserUseCase is a standalone module, responsible for coordinating the flow of data between
 * Presentation Layer and Domain Layer
 */
public class GetUserUseCase {

    private UserRepositoryImpl userRepositoryImpl;
    public GetUserUseCase(UserRepositoryImpl userRepositoryImpl) {
        this.userRepositoryImpl = userRepositoryImpl;
    }

    /**
     *This method fetches the User list method from UserRepository and returns the List to
     * UserViewModel.
     * This method also uses map operator to ignore the users will null username
     * @return Single<List<user>>
     */
    public Single<List<User>> getUserList(){
        return userRepositoryImpl.getUserList()
                .map(new Function<List<User>, List<User>>() {
                    @Override
                    public List<User> apply(List<User> users) throws Exception {
                        List<User> userList = new ArrayList<>();
                        for (User user : users) {
                            if (user.getUsername() != null){
                                userList.add(user);
                            }
                        }
                        return Single.just(userList).blockingGet();
                    }
                });
    }
}
