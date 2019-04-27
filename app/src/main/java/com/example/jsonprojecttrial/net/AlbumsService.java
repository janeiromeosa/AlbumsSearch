package com.example.jsonprojecttrial.net;

import com.example.jsonprojecttrial.Constants;
import com.example.jsonprojecttrial.data.AlbumsResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface AlbumsService {
    @GET(Constants.ENDPOINT)
    Single<List<AlbumsResponse>>getRepos();
}
