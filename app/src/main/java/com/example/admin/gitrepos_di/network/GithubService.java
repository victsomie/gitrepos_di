package com.example.admin.gitrepos_di.network;

import com.example.admin.gitrepos_di.models.GithubRepo;
import com.example.admin.gitrepos_di.models.GithubUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Admin on 2018-05-07.
 */

public interface GithubService {

    @GET("users/{username}/repos")
    Call<List<GithubRepo>> getReposForUser(@Path("username") String username);

    @GET("repositories")
    Call<List<GithubRepo>> getAllRepos();

    @GET("users/{username}")
    Call<List<GithubUser>> getUser(@Path("username") String username);
}
