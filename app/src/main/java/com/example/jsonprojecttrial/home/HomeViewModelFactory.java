package com.example.jsonprojecttrial.home;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.jsonprojecttrial.repo.DataSource;

public class HomeViewModelFactory implements ViewModelProvider.Factory {

    private final DataSource albumsRepository;

    public HomeViewModelFactory(DataSource albumsRepository) {
        this.albumsRepository = albumsRepository;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(HomeViewModel.class)){
            return (T) new HomeViewModel(albumsRepository);
        }throw new IllegalArgumentException("modelClass has to be of type"
                + HomeViewModel.class.getSimpleName());
    }
}
