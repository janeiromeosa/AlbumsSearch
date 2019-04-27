package com.example.jsonprojecttrial.repo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.jsonprojecttrial.data.AlbumsResponse;

import java.util.List;

import io.reactivex.Maybe;

@Dao
public interface AlbumsDAO {
    @Query("SELECT * FROM albums")
    Maybe<List<AlbumsResponse>> getAlbums();

    @Insert
    void addAlbum(AlbumsResponse albumsResponse);

    @Delete
    void deleteAlbum(AlbumsResponse albumsResponse);

    @Update
    void updateAlbum(AlbumsResponse albumsResponse);
}
