package com.example.admin.gitrepos_di.di;

import com.example.admin.gitrepos_di.network.GithubService;
import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Admin on 2018-05-07.
 */

@Module
public class GithubServiceModule {

    @Provides
    public GithubService githubService(Retrofit gitHubRetrofit){
        return gitHubRetrofit.create(GithubService.class);

    }

    @Provides
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson){

        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl("https://api.github.com")
                .build();
    }

}
