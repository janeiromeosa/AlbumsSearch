package com.example.jsonprojecttrial.di.home;

import com.example.jsonprojecttrial.home.MainActivity;
import com.example.jsonprojecttrial.di.app.AppComponent;

import dagger.Component;

@Component(modules = HomeViewModule.class, dependencies = AppComponent.class)
@HomeViewScope
public interface HomeComponent {
    void inject(MainActivity mainActivity);

}
