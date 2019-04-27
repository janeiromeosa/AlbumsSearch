package com.example.jsonprojecttrial.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.jsonprojecttrial.MyApplication;
import com.example.jsonprojecttrial.R;
import com.example.jsonprojecttrial.databinding.ActivityMainBinding;
import com.example.jsonprojecttrial.di.home.DaggerHomeComponent;
import com.example.jsonprojecttrial.di.home.HomeViewModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    HomeViewModel homeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerHomeComponent.builder()
                .appComponent(((MyApplication)getApplication()).getAppComponent())
                .homeViewModule(new HomeViewModule(this))
                .build()
                .inject(this);

        ActivityMainBinding activityMainBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_main);
        //utility class to create viewDataBinding from layouts

        activityMainBinding.setProgressVisibility(homeViewModel.getProgressObservable());
        //i seriously dont know what this does

        AlbumsAdapter albumsAdapter = new AlbumsAdapter();
        //creates a new instance of adapter

        activityMainBinding.rvResults.setLayoutManager(new LinearLayoutManager(this));
        //layout manager created linear layout and passes context so that view can be created in UI

        activityMainBinding.rvResults.setAdapter(albumsAdapter);
        //sets up link between adapter and generated class

        homeViewModel.getAlbumsObservable()
                .observe(this, data ->  albumsAdapter.setData(data));

        //observes/subscribes to observarable in homeviewmodel and passes the list data from
        // there to the recycler view

        homeViewModel.performSearch();





    }
}
