package com.example.jsonprojecttrial.repo;

import com.example.jsonprojecttrial.data.AlbumsResponse;

import java.util.List;

import io.reactivex.Single;

public class AlbumsRepository implements DataSource {

    private final DataSource remoteDataSource;
    private final DataSource localDataSource;

    public AlbumsRepository(DataSource remoteDataSource, DataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    @Override
    public Single<List<AlbumsResponse>> getAlbumsSearch() {
        return remoteDataSource.getAlbumsSearch()
                .doOnSuccess((List<AlbumsResponse> results) -> {
                    for (AlbumsResponse album : results) {
                        addAlbum(album);
                    }
                })
                .onErrorResumeNext(localDataSource.getAlbumsSearch());
    }

    @Override
    public void addAlbum(AlbumsResponse albumsResponse) {
        localDataSource.addAlbum(albumsResponse);
    }
}
