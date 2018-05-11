package com.example.admin.gitrepos_di.di;

import com.example.admin.gitrepos_di.network.GithubService;
import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * Created by Admin on 2018-05-07.
 */

@Component (modules = GithubService.class)
public interface GitHubApplicationComponent {

    Picasso getPicasso();

    GithubService getGithubService();
}

