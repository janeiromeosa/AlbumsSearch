package com.example.jsonprojecttrial.home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import com.example.jsonprojecttrial.data.AlbumsResponse;
import com.example.jsonprojecttrial.repo.DataSource;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends ViewModel {

    private final ObservableBoolean progressObservable;
    private final MutableLiveData<List<AlbumsResponse>> albumsObservable;
    private final DataSource albumsRepository;
    private final CompositeDisposable compositeDisposable;


    public HomeViewModel(DataSource albumsRepository) {
        this.progressObservable = new ObservableBoolean();
        this.albumsObservable = new MutableLiveData<>();
        this.albumsRepository = albumsRepository;
        this.compositeDisposable = new CompositeDisposable();
    }

    public ObservableBoolean getProgressObservable(){return progressObservable;}

    public LiveData<List<AlbumsResponse>> getAlbumsObservable(){return albumsObservable;}

    public void performSearch() {
        compositeDisposable.add(albumsRepository.getAlbumsSearch()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> progressObservable.set(true))
                .doOnEvent((success, failure) -> progressObservable.set(false))
                .subscribe(albumsObservable::setValue, throwable -> throwable.printStackTrace()));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}
