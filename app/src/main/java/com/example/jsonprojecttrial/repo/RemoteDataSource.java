package com.example.jsonprojecttrial.repo;

import android.util.Log;

import com.example.jsonprojecttrial.data.AlbumsResponse;
import com.example.jsonprojecttrial.net.AlbumsService;

import java.util.List;

import io.reactivex.Single;

public class RemoteDataSource implements DataSource {

    private final AlbumsService albumsService;

    public RemoteDataSource(AlbumsService albumsService) {
        this.albumsService = albumsService;
    }


    @Override
    public Single<List<AlbumsResponse>> getAlbumsSearch() {
        Log.d("Retrofit", "Retofit called");
        return albumsService.getRepos()
                .map(albumsResponses -> albumsResponses);
    }

    @Override
    public void addAlbum(AlbumsResponse albumsResponse) {

    }
}
