package com.example.admin.gitrepos_di.di;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.icu.text.DateFormat;
import android.icu.util.Calendar;

import com.example.admin.gitrepos_di.network.GithubService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by Admin on 2018-05-07.
 */

public class GithubApplication extends Application {

    Context context;
    Picasso picasso;

    public static GithubApplication get(Activity activity){
        return (GithubApplication) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();

// Context
        context = this;

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new DateFormat() {
            @Override
            public StringBuffer format(Calendar calendar, StringBuffer stringBuffer, FieldPosition fieldPosition) {
                return null;
            }

            @Override
            public void parse(String s, Calendar calendar, ParsePosition parsePosition) {

            }
        });
        Gson gson = gsonBuilder.create();


        // Cool library for logging
        Timber.plant(new Timber.DebugTree());

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        });

        File cacheFile = new File(context.getCacheDir(), "okhttp_cache");
        cacheFile.mkdir();


        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();


        picasso = new Picasso.Builder(this)
                .downloader(new OkHttp3Downloader(okHttpClient))
                .build();


    }
    GithubService githubService;

    public GithubService getGithubService(){
        return githubService;
    }
}
