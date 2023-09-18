package com.appinventiv.cleanarchitecturesample.presentation.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.appinventiv.cleanarchitecturesample.R;
import com.appinventiv.cleanarchitecturesample.presentation.adapter.ItemAdapter;
import com.appinventiv.cleanarchitecturesample.presentation.viewmodel.UserViewModel;

/**
 * This Activity shows single screen in Android device.
 * A recyclerview contains the list of User's data, is placed in UI.
 */
public class HomeActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
    private ItemAdapter mItemAdapter;
    private ContentLoadingProgressBar progressBar;

    /**
     * This is a starting point of App UI
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        progressBar = findViewById(R.id.progressBar);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        setUpRecyclerView();
        observeUsers();
    }

    /**
     * This method observes the user list livedata in viewModel class.
     * It also updates the adapter on a Success API response and manager the Progress bar accordingly
     */
    private void observeUsers(){
        userViewModel.usersListLiveData.observe(this, users -> {
            switch (users.status){
                case SUCCESS:
                    progressBar.hide();
                    if (users.data != null) {
                        mItemAdapter.notifyAdapter(users.data);
                    }
                    break;
                case ERROR:
                    progressBar.hide();
                    break;
                case LOADING:
                    progressBar.show();
                    break;
            }
        });
    }

    /**
     * This method initiates the recyclerview instance and
     * assign layout Manager and adapter to it
     */
    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        mItemAdapter = new ItemAdapter();
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mItemAdapter);

    }
}