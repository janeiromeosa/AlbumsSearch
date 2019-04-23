package com.example.jsonprojecttrial.di;

import android.app.Application;

import dagger.BindsInstance;
import dagger.Component;

public interface AppComponent {

    @Component.Builder
    interface Builder {
        AppComponent build();

        @BindsInstance
        Builder application(Application application);
    }
}
