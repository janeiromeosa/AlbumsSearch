package com.example.jsonprojecttrial.di.home;

import android.arch.lifecycle.ViewModelProviders;

import com.example.jsonprojecttrial.home.MainActivity;
import com.example.jsonprojecttrial.di.app.Repository;
import com.example.jsonprojecttrial.home.HomeViewModel;
import com.example.jsonprojecttrial.home.HomeViewModelFactory;
import com.example.jsonprojecttrial.repo.DataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeViewModule {

    private final MainActivity mainActivity;

    public HomeViewModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }


    @Provides
    @HomeViewScope
    public HomeViewModelFactory provideHomeViewModelFactory(@Repository DataSource albumsRepository) {
        return new HomeViewModelFactory(albumsRepository);
    }

    @Provides
    @HomeViewScope
    public HomeViewModel provideHomeViewModel(HomeViewModelFactory homeViewModelFactory){
        return ViewModelProviders.of(mainActivity, homeViewModelFactory).get(HomeViewModel.class);
    }

}
