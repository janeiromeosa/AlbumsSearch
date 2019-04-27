package com.example.jsonprojecttrial.repo;

import com.example.jsonprojecttrial.data.AlbumsResponse;

import java.util.List;

import io.reactivex.Single;

public class LocalDataSource implements DataSource{

    private final AlbumsDatabase albumsDatabase;

    public LocalDataSource(AlbumsDatabase albumsDatabase) {
        this.albumsDatabase = albumsDatabase;
    }


    @Override
    public Single<List<AlbumsResponse>> getAlbumsSearch() {
        return albumsDatabase.albumsDAO().getAlbums().toSingle();
    }

    @Override
    public void addAlbum(AlbumsResponse albumsResponse) {
        albumsDatabase.albumsDAO().addAlbum(albumsResponse);
    }
}
