package com.appinventiv.cleanarchitecturesample.presentation.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.appinventiv.cleanarchitecturesample.R;
import com.appinventiv.cleanarchitecturesample.algorithm.recursion.HalfPyramid;
import com.appinventiv.cleanarchitecturesample.algorithm.recursion.LinearSearch;
import com.appinventiv.cleanarchitecturesample.algorithm.recursion.RBubbleSort;
import com.appinventiv.cleanarchitecturesample.algorithm.recursion.RMergeSort;
import com.appinventiv.cleanarchitecturesample.algorithm.recursion.RSelectionSort;
import com.appinventiv.cleanarchitecturesample.algorithm.sorting.BubbleSort;
import com.appinventiv.cleanarchitecturesample.algorithm.sorting.QuickSort;
import com.appinventiv.cleanarchitecturesample.algorithm.sorting.SelectionSort;
import com.appinventiv.cleanarchitecturesample.presentation.adapter.ItemAdapter;
import com.appinventiv.cleanarchitecturesample.presentation.viewmodel.UserViewModel;

import okhttp3.internal.connection.RouteSelector;

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
//        setUpRecyclerView();
//        observeUsers();
//        findNumber(10);
//        totalNumberLessThan(10);
//        totalNumberGreaterThan(10);
//        new BinarySearch().BinarySearchAlgorithm(false);
//        new Fibonacci().fibonacciSeries();
//        new MergeSort().mergeSortAlgo();
//        new PrintNto1().printNumberRecursion();
//        new SumOfDigits().sumOfDigit();
//        new ReverseNum().reverseANum();
//        new SortedArray().isArraySorted();
//        new LinearSearch().linearSearch();
//        new LinearSearch().allNumberLinearSearch();
//        new HalfPyramid().printHalfPyramid();
//        new BubbleSort().bubbleSort();
//        new SelectionSort().selectionSort();
//        new RBubbleSort().RecursionBubbleSort();
//        new RSelectionSort().selectionSort();
//        new RMergeSort().mergeSortRecursion();
        new QuickSort().quickSortAlgo();
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