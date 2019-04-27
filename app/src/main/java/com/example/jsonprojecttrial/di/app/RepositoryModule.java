package com.example.jsonprojecttrial.di.app;

import com.example.jsonprojecttrial.repo.AlbumsRepository;
import com.example.jsonprojecttrial.repo.DataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    @Repository
    public DataSource provideRepository(@Remote DataSource remoteDataSource, @Local DataSource localDataSource ) {
        return new AlbumsRepository(remoteDataSource, localDataSource);
    }
}
