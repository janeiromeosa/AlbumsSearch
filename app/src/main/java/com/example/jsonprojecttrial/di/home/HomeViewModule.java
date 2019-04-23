package com.example.jsonprojecttrial.di.home;

import android.arch.lifecycle.ViewModelProviders;

import com.example.jsonprojecttrial.MainActivity;
import com.example.jsonprojecttrial.di.app.Repository;
import com.example.jsonprojecttrial.home.HomeViewModel;
import com.example.jsonprojecttrial.home.HomeViewModelFactory;
import com.example.jsonprojecttrial.repo.DataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeViewFactoryModule {

    private final MainActivity homeActivity;

    public HomeViewFactoryModule(MainActivity homeActivity) {
        this.homeActivity = homeActivity;
    }


    @Provides
    @Singleton
    public HomeViewModelFactory provideHomeViewModelFactory(@Repository DataSource albumsRepository) {
        return new HomeViewModelFactory(albumsRepository);
    }

    @Provides
    public HomeViewModel provideHomeViewModel(HomeViewModelFactory homeViewModelFactory){
        return ViewModelProviders.of(homeActivity, homeViewModelFactory).get(HomeViewModel.class);
    }

}
