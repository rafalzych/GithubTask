package com.rafalzych.github.task.data.network

import com.rafalzych.github.task.data.repository.GithubRemote
import com.rafalzych.github.task.model.Repo
import com.rafalzych.github.task.model.User
import io.reactivex.Single

class GithubRemoteImpl : GithubRemote {

    private val networkService by lazy {
        NetworkServiceFactory().makeRetrofitService().create(GithubNetworkService::class.java)
    }

    override fun getGithubUsers(): Single<List<User>> {
        return networkService.getGithubUsers()
    }

    override fun getUsersRepositories(userName: String): Single<List<Repo>> {
        return networkService.getUserRepositories(userName)
    }
}