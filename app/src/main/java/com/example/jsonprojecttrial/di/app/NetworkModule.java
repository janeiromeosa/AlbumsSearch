package com.example.jsonprojecttrial.di.app;


import android.app.Application;

import com.example.jsonprojecttrial.Constants;
import com.example.jsonprojecttrial.net.AlbumsService;
import com.example.jsonprojecttrial.repo.DataSource;
import com.example.jsonprojecttrial.repo.RemoteDataSource;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public Cache provideCache(Application application){
        return new Cache(application.getCacheDir(), Constants.CACHE_SIZE);
    }

    @Provides
    @Singleton
    public HttpLoggingInterceptor provideHttpLoggingInterceptor() {//Logger
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    public OkHttpClient provideOKHttpClient(Cache cache, HttpLoggingInterceptor loggingInterceptor)  {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .readTimeout(Constants.API_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(Constants.API_TIMEOUT, TimeUnit.SECONDS)
                .cache(cache)
                .build();
    }
    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public AlbumsService provideAlbumsService(Retrofit retrofit) {
        return retrofit.create(AlbumsService.class);
    }

    @Provides
    @Singleton
    @Remote
    public DataSource provideRemoteDataSource(AlbumsService albumsService) {
        return new RemoteDataSource(albumsService);
    }


}
