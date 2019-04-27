package com.example.jsonprojecttrial.di.app;

import android.app.Application;

import com.example.jsonprojecttrial.repo.DataSource;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Module;

@Component(modules = {NetworkModule.class, RepositoryModule.class, DatabaseModule.class})
@Singleton
public interface AppComponent {

    @Repository
    DataSource repository();

    @Component.Builder
    interface Builder {
        AppComponent build();

        @BindsInstance
        Builder application(Application application);
    }
}
