package com.example.jsonprojecttrial.repo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.jsonprojecttrial.Constants;
import com.example.jsonprojecttrial.data.AlbumsResponse;

@Database(entities = {AlbumsResponse.class}, version = Constants.DATABASE_VERSION)
public abstract class AlbumsDatabase extends RoomDatabase {

    public abstract AlbumsDAO albumsDAO();
}
