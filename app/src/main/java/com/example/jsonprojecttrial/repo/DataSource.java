package com.example.jsonprojecttrial.repo;

import com.example.jsonprojecttrial.data.AlbumsResponse;

import java.util.List;

import io.reactivex.Single;

public interface DataSource {
    Single<List<AlbumsResponse>> getAlbumsSearch();
    void addAlbum(AlbumsResponse albumsResponse);

}
