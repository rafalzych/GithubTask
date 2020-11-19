package com.rafalzych.github.task.data.network

import com.rafalzych.github.task.data.repository.GithubRemote
import com.rafalzych.github.task.model.RepositoriesResponse
import com.rafalzych.github.task.model.UsersResponse
import io.reactivex.Single

class GithubRemoteImpl : GithubRemote {

    private val networkService by lazy {
        NetworkServiceFactory().makeRetrofitService().create(GithubNetworkService::class.java)
    }

    override fun getGithubUsers(): Single<UsersResponse> {
        return networkService.getGithubUsers()
    }

    override fun getUsersRepositories(userName: String): Single<RepositoriesResponse> {
        return networkService.getUserRepositories(userName)
    }
}