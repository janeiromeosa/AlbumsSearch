package com.example.jsonprojecttrial.di;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.jsonprojecttrial.repo.AlbumsDatabase;
import com.example.jsonprojecttrial.repo.DataSource;
import com.example.jsonprojecttrial.repo.LocalDataSource;

import javax.inject.Singleton;

import dagger.Provides;

public class DatabaseModule {
    @Provides
    @Singleton
    public AlbumsDatabase provideJsonDatabase(Application application) {
        return Room.databaseBuilder(application, AlbumsDatabase.class, "JSonDatabase").build();
    }
    @Provides
    @Singleton
    @Local
    public DataSource provideLocalDataSource(AlbumsDatabase jsonDatabase) {
        return new LocalDataSource(jsonDatabase);
    }
}
