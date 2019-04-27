package com.example.jsonprojecttrial;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableBoolean;

import com.example.jsonprojecttrial.data.AlbumsResponse;
import com.example.jsonprojecttrial.home.HomeViewModel;
import com.example.jsonprojecttrial.repo.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

public class HomeViewModelTest {

    @Mock
    private DataSource albumsRepository;

    ObservableBoolean progressObservable = new ObservableBoolean();
    MutableLiveData<List<AlbumsResponse>> albumsObservable = new MutableLiveData<>();
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    private HomeViewModel homeViewModel;


    @Before
    public void setup(){
        homeViewModel = new HomeViewModel(albumsRepository);
    }

    @Test
    public void performSearch(){

    }


}
