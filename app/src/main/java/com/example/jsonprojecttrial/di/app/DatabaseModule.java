package com.example.jsonprojecttrial.di.app;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.jsonprojecttrial.Constants;
import com.example.jsonprojecttrial.repo.AlbumsDatabase;
import com.example.jsonprojecttrial.repo.DataSource;
import com.example.jsonprojecttrial.repo.LocalDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {
    @Provides
    @Singleton
    public AlbumsDatabase provideJsonDatabase(Application application) {
        return Room.databaseBuilder(application, AlbumsDatabase.class, Constants.DATABASE_NAME).build();
    }
    @Provides
    @Singleton
    @Local
    public DataSource provideLocalDataSource(AlbumsDatabase albumsDatabase) {
        return new LocalDataSource(albumsDatabase);
    }
}
