package com.garrett.retrofit_setup;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {
    @GET("users/{uid}/posts")
    Call<List<Post>> getPosts(@Path ("uid") int uid);
}
